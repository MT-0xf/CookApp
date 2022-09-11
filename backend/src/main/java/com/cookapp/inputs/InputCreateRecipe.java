package com.cookapp.inputs;

import com.cookapp.inputs.model.InputIngredient;
import com.cookapp.inputs.model.InputCookProcedure;
import com.cookapp.inputs.model.InputRecipeData;
import lombok.Data;

import java.util.List;

@Data
public class InputCreateRecipe {
    private InputRecipeData recipeData;
    private List<InputIngredient> ingredients;
    private List<InputCookProcedure> procedures;

    public InputRecipeData getRecipeData() {
        return recipeData;
    }

    public List<InputIngredient> getIngredients() {
        return this.ingredients;
    }

    public List<InputCookProcedure> getProcedures() {
        return this.procedures;
    }

    public void setRecipeData(InputRecipeData recipeData) {
        this.recipeData = recipeData;
    }

    public void setIngredients(List<InputIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setProcedures(List<InputCookProcedure> procedures) {
        this.procedures = procedures;
    }

    public boolean isValid() {
        if (!this.recipeData.isValid()) {
            return false;
        }

        for (InputIngredient ingredient: this.ingredients) {
            if (!ingredient.isValid()) {
                return false;
            }
        }

        for (InputCookProcedure procedure: this.procedures) {
            if (!procedure.isValid()) {
                return false;
            }
        }

        return true;
    }
}
