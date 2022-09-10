package com.cookapp.types;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {
    @Id
    @Column(name = "recipe_id")
    private String recipeId;

    @Id
    @Column(name = "ingredient_id")
    private String ingredientId;

    @Column(name = "amount")
    private String amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
    private RecipeData recipeData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
    private IngredientMaster ingredientMaster;

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

    public IngredientMaster getIngredientMaster() {
        return this.ingredientMaster;
    }

    public void setIngredientMaster(IngredientMaster ingredientMaster) {
        this.ingredientMaster = ingredientMaster;
    }
}
