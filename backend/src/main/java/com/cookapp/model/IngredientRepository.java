package com.cookapp.model;

import com.cookapp.inputs.InputIngredient;
import com.cookapp.types.Ingredient;
import com.cookapp.types.RegisterIngredientResponse;

import java.util.List;

public interface IngredientRepository {
    List<Ingredient> getIngredients();
    RegisterIngredientResponse registerIngredients(List<InputIngredient> ingredients);
}
