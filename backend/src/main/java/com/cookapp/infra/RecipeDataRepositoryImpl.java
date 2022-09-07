package com.cookapp.infra;

import com.cookapp.model.RecipeDataRepository;
import com.cookapp.types.RecipeData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class RecipeDataRepositoryImpl implements RecipeDataRepository {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<RecipeData> getRecipeData() {
        String query = "SELECT rd FROM RecipeData rd INNER JOIN FETCH rd.ingredients ig INNER JOIN FETCH ig.ingredientMaster";

        List<RecipeData> recipeData = entityManager
                .createQuery(query, RecipeData.class)
                .getResultList();

        List<RecipeData> results = new ArrayList<>(new HashSet<>(recipeData));

        return results;
    }
}
