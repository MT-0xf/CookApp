package com.cookapp.types;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class RegisterIngredientResponse {
    private List<Ingredient> ingredients;
    private boolean isRegister;
    private String errorMessage;

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setRegister(boolean isRegister) {
        this.isRegister = isRegister;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
