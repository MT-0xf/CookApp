package com.cookapp.model;

import com.cookapp.types.RecipeData;

import java.util.List;

public interface RecipeDataRepository {
    public List<RecipeData> getRecipeData();
    public List<RecipeData> getRecipeCookProcedures();
}
