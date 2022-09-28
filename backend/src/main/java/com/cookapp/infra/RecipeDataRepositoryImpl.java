package com.cookapp.infra;

import com.cookapp.infra.S3Service.FileUploadService;
import com.cookapp.infra.S3Service.S3Config;
import com.cookapp.inputs.InputCookProcedure;
import com.cookapp.inputs.InputCreateRecipe;
import com.cookapp.inputs.InputIngredient;
import com.cookapp.inputs.InputIngredientMaster;
import com.cookapp.repository.RecipeDataRepository;
import com.cookapp.types.RecipeData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class RecipeDataRepositoryImpl implements RecipeDataRepository {
    @Autowired
    EntityManager entityManager;
    S3Config s3Client;
    FileUploadService fileUploadService;

    public RecipeDataRepositoryImpl(S3Config s3Client) {
        this.s3Client =  s3Client;
        this.fileUploadService = new FileUploadService(s3Client.s3Client());
    }

    @Override
    public List<RecipeData> getRecipeData() {
        String query = "SELECT rd FROM RecipeData rd INNER JOIN FETCH rd.ingredients ig INNER JOIN FETCH ig.ingredientMaster";

        List<RecipeData> recipeData = entityManager
                .createQuery(query, RecipeData.class)
                .getResultList();

        List<RecipeData> results = new ArrayList<>(new HashSet<>(recipeData));

        return results;
    }

    @Override
    public List<RecipeData> getRecipeCookProcedures() {
        String query = "SELECT rd FROM RecipeData rd INNER JOIN FETCH rd.cookProcedures";

        List<RecipeData> recipeData = entityManager
                .createQuery(query, RecipeData.class)
                .getResultList();

        List<RecipeData> results = new ArrayList<>(new HashSet<>(recipeData));

        return results;
    }

    @Override
    public RecipeData getRecipeCookProcedureById(String id) {
        String query = "SELECT rd FROM RecipeData rd INNER JOIN FETCH rd.cookProcedures WHERE rd.recipe_id = :id";

        RecipeData recipeData = entityManager
                .createQuery(query, RecipeData.class)
                .setParameter("id", id)
                .getSingleResult();

        RecipeData result = recipeData;

        return result;
    }

    @Transactional
    @Override
    public boolean registerRecipeData(InputCreateRecipe inputCreateRecipe) throws IOException {
        if (!inputCreateRecipe.isValid()) {
            return false;
        }

        // RecipeData登録
        String recipeId = UUID.randomUUID().toString();
        inputCreateRecipe.getRecipeData().setRecipeId(recipeId);

        // 画像ファイルアップロード
        String recipeDataImg = fileUploadService.fileUpload(inputCreateRecipe.getRecipeData().getImg());
        inputCreateRecipe.getRecipeData().setImg(recipeDataImg);

        entityManager.
                createNativeQuery("INSERT INTO recipe_data (recipe_id, dish_name, img) VALUES (:recipeId, :dishName, :img)")
                .setParameter("recipeId", inputCreateRecipe.getRecipeData().getRecipeId())
                .setParameter("dishName", inputCreateRecipe.getRecipeData().getDishName())
                .setParameter("img", inputCreateRecipe.getRecipeData().getImg())
                .executeUpdate();

        // Ingredient および IngredientMaster 登録
        for (InputIngredient ingredient: inputCreateRecipe.getIngredients()) {
            String ingredientName = ingredient.getIngredientName();

            // IngredientMasterにすでに登録済みの材料か検索
            String ingredientId = "";
            try {
                InputIngredientMaster ingredientMaster = (InputIngredientMaster)entityManager.
                        createNativeQuery("SELECT * FROM ingredient_master WHERE ingredient_name = :ingredientName", InputIngredientMaster.class)
                        .setParameter("ingredientName", ingredientName)
                        .getSingleResult();

                // 登録済み材料のIDを取得
                ingredientId = ingredientMaster.getIngredientId();
            }
            catch (NoResultException exception){
                // 新規材料をIngredientMasterに登録
                ingredientId = UUID.randomUUID().toString();
                entityManager.
                        createNativeQuery("INSERT INTO ingredient_master (ingredient_id, ingredient_name) VALUES (:ingredientId, :ingredientName)")
                        .setParameter("ingredientId", ingredientId)
                        .setParameter("ingredientName", ingredient.getIngredientName())
                        .executeUpdate();
            }

            // 材料をIngredientに登録
            ingredient.setRecipeId(recipeId);
            ingredient.setIngredientId(ingredientId);
            entityManager.
                    createNativeQuery("INSERT INTO ingredient (recipe_id, ingredient_id, amount) VALUES (:recipeId, :ingredientId, :amount)")
                    .setParameter("recipeId", ingredient.getRecipeId())
                    .setParameter("ingredientId", ingredient.getIngredientId())
                    .setParameter("amount", ingredient.getAmount())
                    .executeUpdate();
        }

        // 手順をCookProcedureに登録
        for (InputCookProcedure cookProcedure: inputCreateRecipe.getProcedures()) {
            cookProcedure.setRecipeId(recipeId);

            // 画像ファイルアップロード
            String cookProcedureImg = fileUploadService.fileUpload(cookProcedure.getImg());
            cookProcedure.setImg(cookProcedureImg);

            entityManager.
                    createNativeQuery("INSERT INTO cook_procedure (recipe_id, order_number, method, img) VALUES (:recipeId, :orderNumber, :method, :img)")
                    .setParameter("recipeId", cookProcedure.getRecipeId())
                    .setParameter("orderNumber", cookProcedure.getOrderNumber())
                    .setParameter("method", cookProcedure.getMethod())
                    .setParameter("img", cookProcedure.getImg())
                    .executeUpdate();
        }

        return true;
    }
}
