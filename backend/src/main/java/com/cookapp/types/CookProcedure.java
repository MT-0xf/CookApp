package com.cookapp.types;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "cook_procedure")
public class CookProcedure implements Serializable {
    @Id
    @Column(name = "recipe_id")
    private String recipeId;

    @Id
    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "method")
    private String method;

    @Column(name = "img")
    private String img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
    private RecipeData recipeData;
}
