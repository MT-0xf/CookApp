package com.cookapp.inputs.model;

import lombok.Data;

@Data
public class InputIngredient {
    private String recipeId;

    private String ingredientId;

    private String ingredientName;

    private String amount;

    public String getRecipeId() {
        return this.recipeId;
    }

    public String getIngredientId() {
        return this.ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
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

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public boolean isValid() {
//        if (this.recipeId == null || this.recipeId.length() > 200) {
//            return false;
//        }
//
//        if (this.ingredientId == null || this.ingredientId.length() > 200) {
//            return false;
//        }

        if (this.ingredientName == null || this.ingredientName.length() > 45) {
            return false;
        }

        if (this.amount == null || this.amount.length() > 45) {
            return false;
        }

        return true;
    }
}

