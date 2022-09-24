package com.cookapp.resolvers;

import com.cookapp.infra.RecipeDataRepositoryImpl;
import com.cookapp.inputs.InputCreateRecipe;
import com.cookapp.repository.RecipeDataRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class RecipeDataMutationResolver implements GraphQLMutationResolver {
    private RecipeDataRepository recipeDataRepository;

    public RecipeDataMutationResolver(RecipeDataRepositoryImpl recipeDataRepository) {
        this.recipeDataRepository = recipeDataRepository;
    }

    public boolean registerRecipeData(InputCreateRecipe inputCreateRecipe) throws IOException {
        return this.recipeDataRepository.registerRecipeData(inputCreateRecipe);
    }
}
