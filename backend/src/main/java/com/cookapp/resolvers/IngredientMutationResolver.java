package com.cookapp.resolvers;

import com.cookapp.infra.IngredientRepositoryImpl;
import com.cookapp.inputs.InputIngredient;
import com.cookapp.types.RegisterIngredientResponse;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class IngredientMutationResolver implements GraphQLMutationResolver {
    private IngredientRepositoryImpl ingredientRepository;

    public IngredientMutationResolver(IngredientRepositoryImpl ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public RegisterIngredientResponse registerIngredients(List<InputIngredient> ingredients) {
        return this.ingredientRepository.registerIngredients(ingredients);
    }
}
