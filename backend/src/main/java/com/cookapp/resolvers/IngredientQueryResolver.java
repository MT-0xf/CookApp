package com.cookapp.resolvers;

import com.cookapp.infra.IngredientRepositoryImpl;
import com.cookapp.types.Ingredient;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class IngredientQueryResolver implements GraphQLQueryResolver {
    private final IngredientRepositoryImpl ingredientRepository;

    public IngredientQueryResolver(IngredientRepositoryImpl ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredientRepository.getIngredients();
    }
}
