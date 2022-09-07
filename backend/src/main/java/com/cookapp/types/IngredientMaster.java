package com.cookapp.types;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ingredient_master")

public class IngredientMaster {
    @Id
    @Column(name = "ingredient_id")
    private String ingredientId;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @OneToMany(mappedBy = "ingredientId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredient;
}
