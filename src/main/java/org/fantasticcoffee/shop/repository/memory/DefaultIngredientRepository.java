package org.fantasticcoffee.shop.repository.memory;

import org.fantasticcoffee.shop.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("ingredientsRepositoryMemory")
public class DefaultIngredientRepository {

    private List<Ingredient> database;

    public DefaultIngredientRepository() {
        this.database = new ArrayList<>();
    }

    public boolean save(Ingredient ingredient) {

        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        return database.add(ingredient);
    }

    public Optional<Ingredient> find(Integer id) {

        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return Optional.ofNullable(database.get(id));
    }

    public Ingredient find(Ingredient ingredient) {

        return database.stream()
                .filter(foundIngredient -> foundIngredient == ingredient)
                .findFirst()
                .orElseThrow();
    }

    public Optional<Ingredient> update(Integer id, Ingredient ingredient) {
        return Optional.ofNullable(database.set(id, ingredient));
    }

    public List<Ingredient> findAll() {
        return database;
    }
}