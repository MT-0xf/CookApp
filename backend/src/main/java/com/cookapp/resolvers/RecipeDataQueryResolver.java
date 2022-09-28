package com.cookapp.resolvers;

import com.cookapp.infra.RecipeDataRepositoryImpl;
import com.cookapp.types.RecipeData;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class RecipeDataQueryResolver implements GraphQLQueryResolver {
    private final RecipeDataRepositoryImpl recipeDataRepository;

    public RecipeDataQueryResolver(RecipeDataRepositoryImpl recipeDataRepository) {
        this.recipeDataRepository = recipeDataRepository;
    }

    public List<RecipeData> getRecipeData() throws IOException {
        return this.recipeDataRepository.getRecipeData();
    }

    public List<RecipeData> getRecipeCookProcedures() {
        return this.recipeDataRepository.getRecipeCookProcedures();
    }

    public RecipeData getRecipeCookProcedureById(String id) {
        return this.recipeDataRepository.getRecipeCookProcedureById(id);
    }
}
