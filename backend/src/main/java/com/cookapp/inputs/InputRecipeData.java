package com.cookapp.inputs;

import lombok.Data;

@Data
public class InputRecipeData {
    private String recipeId;
    private String dishName;
    private String img;

    public String getRecipeId() {
        return this.recipeId;
    }

    public String getDishName() {
        return this.dishName;
    }

    public String getImg() { return this.img; }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isValid() {
//        if (this.recipeId == null || this.recipeId.length() > 200) {
//            return false;
//        }

        if (this.dishName == null || this.dishName.length() > 45) {
            return false;
        }

        if (this.img == null) {
            return false;
        }

        return true;
    }
}
