package com.cookapp.inputs;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InputIngredientMaster {
    @Id
    private String ingredientId;

    private String ingredientName;

    public String getIngredientId() {
        return this.ingredientId;
    }

    public String getIngredientName() {
        return this.ingredientName;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public boolean isValid() {
//        if (this.ingredientId == null || this.ingredientId.length() > 200) {
//            return false;
//        }

        if (this.ingredientName == null || this.ingredientName.length() > 45) {
            return false;
        }

        return true;
    }
}
