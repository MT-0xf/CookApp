package com.cookapp.resolvers;

import com.cookapp.infra.RecipeDataRepositoryImpl;
import com.cookapp.types.RecipeData;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class RecipeDataQueryResolver implements GraphQLQueryResolver {
    private final RecipeDataRepositoryImpl recipeDataRepository;

    public RecipeDataQueryResolver(RecipeDataRepositoryImpl recipeDataRepository) {
        this.recipeDataRepository = recipeDataRepository;
    }

    public List<RecipeData> getRecipeData() {
        return this.recipeDataRepository.getRecipeData();
    }

    public List<RecipeData> getRecipeCookProcedures() {
        return this.recipeDataRepository.getRecipeCookProcedures();
    }
}
