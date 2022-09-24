package com.cookapp.inputs;

import lombok.Data;

@Data
public class InputCookProcedure {
    private String recipeId;
    private int orderNumber;
    private String method;
    private String img;

    public String getRecipeId() {
        return this.recipeId;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public String getMethod() {
        return this.method;
    }

    public String getImg() {
        return this.img;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public void setOrderNumber(int order) {
        this.orderNumber = order;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isValid() {
//        if (this.recipeId == null || this.recipeId.length() > 200) {
//            return false;
//        }

        if (this.method == null || this.method.length() > 200) {
            return false;
        }

        if (this.img == null) {
            return false;
        }

        return true;
    }
}
