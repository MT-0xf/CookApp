package com.cookapp.infra;

import com.cookapp.inputs.InputIngredient;
import com.cookapp.repository.IngredientRepository;
import com.cookapp.types.Ingredient;
import com.cookapp.types.RegisterIngredientResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class IngredientRepositoryImpl implements IngredientRepository {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> results = entityManager
                .createQuery("from Ingredient", Ingredient.class)
                .getResultList();

        return results;
    }

    @Transactional
    @Override
    public RegisterIngredientResponse registerIngredients(List<InputIngredient> ingredients) {
        List<Ingredient> outputIngredients = new ArrayList<>();

        for (InputIngredient ingredient: ingredients) {
            entityManager.
                    createNativeQuery("INSERT INTO ingredient (recipe_id, ingredient_id, amount) VALUES (:recipeId, :ingredientId, :amount)")
                    .setParameter("recipeId", ingredient.getRecipeId())
                    .setParameter("ingredientId", ingredient.getIngredientId())
                    .setParameter("amount", ingredient.getAmount())
                    .executeUpdate();

            Ingredient outputIngredient = new Ingredient();
            outputIngredient.setRecipeId(ingredient.getRecipeId());
            outputIngredient.setIngredientId(ingredient.getIngredientId());
            outputIngredient.setAmount(ingredient.getAmount());
            outputIngredients.add(outputIngredient);
        }

        RegisterIngredientResponse response = new RegisterIngredientResponse();
        response.setIngredients(outputIngredients);
        response.setRegister(true);
        response.setErrorMessage("");

        return response;
    }
}
