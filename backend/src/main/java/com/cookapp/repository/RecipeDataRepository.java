package com.cookapp.repository;

import com.cookapp.inputs.InputCreateRecipe;
import com.cookapp.types.RecipeData;

import java.util.List;

public interface RecipeDataRepository {
    public List<RecipeData> getRecipeData();
    public List<RecipeData> getRecipeCookProcedures();
    public boolean registerRecipeData(InputCreateRecipe inputCreateRecipe);
}
