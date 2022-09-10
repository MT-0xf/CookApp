package com.cookapp.inputs;

import lombok.Data;

import java.util.List;

@Data
public class InputCreateRecipe {
    private String dishName;
    private List<InputIngredient> ingredients;
    private List<InputProcedure> procedures;
}
