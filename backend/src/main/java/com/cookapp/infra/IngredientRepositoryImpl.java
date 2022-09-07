package com.cookapp.infra;

import com.cookapp.model.IngredientRepository;
import com.cookapp.types.Ingredient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class IngredientRepositoryImpl implements IngredientRepository {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> results = entityManager
                .createQuery("from Ingredient", Ingredient.class)
                .getResultList();

        return results;
    }
}
