package com.cookapp.types;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "recipe_data")
public class RecipeData {
    @Id
    @Column(name = "recipe_id")
    private String recipeId;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "img")
    private String img;

    @OneToMany(mappedBy = "recipeId", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Ingredient> ingredients = new ArrayList<Ingredient>();

    @OneToMany(mappedBy = "recipeId", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CookProcedure> cookProcedures = new ArrayList<CookProcedure>();
}
