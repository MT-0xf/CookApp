package com.cookapp.inputs;

import lombok.Data;

@Data
public class InputIngredient {
    private String recipeId;

    private String ingredientId;

    private String amount;

    public String getRecipeId() {
        return this.recipeId;
    }

    public String getIngredientId() {
        return this.ingredientId;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

