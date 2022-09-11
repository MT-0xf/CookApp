package com.cookapp.inputs.model;

import lombok.Data;

@Data
public class InputRecipeData {
    private String recipeId;
    private String dishName;

    public String getRecipeId() {
        return this.recipeId;
    }

    public String getDishName() {
        return this.dishName;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public boolean isValid() {
//        if (this.recipeId == null || this.recipeId.length() > 200) {
//            return false;
//        }

        if (this.dishName == null || this.dishName.length() > 45) {
            return false;
        }

        return true;
    }
}
