package com.cookapp.types;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @Column(name = "recipe_id")
    private String recipeId;

    @Column(name = "ingredient_id")
    private String ingredientId;

    @Column(name = "amount")
    private String amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
    private RecipeData recipeData;
}
