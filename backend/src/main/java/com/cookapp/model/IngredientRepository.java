package com.cookapp.model;

import com.cookapp.types.Ingredient;

import java.util.List;

public interface IngredientRepository {
    List<Ingredient> getIngredients();
}
