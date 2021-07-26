package org.fantasticcoffee.shop.service.impl;

import org.fantasticcoffee.shop.model.ingredientdefinition.BaseIngredient;
import org.fantasticcoffee.shop.model.ingredientonrecipe.BaseIngredientOnRecipe;
import org.fantasticcoffee.shop.model.stock.BaseIngredientInStock;
import org.fantasticcoffee.shop.repository.DefaultBaseIngredientRepository;
import org.fantasticcoffee.shop.service.BaseIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("baseIngredientService")
public class DefaultBaseIngredientService implements BaseIngredientService {

    private static Integer id = 0;

    @Autowired
    DefaultBaseIngredientRepository baseIngredientRepository;

    @Override
    public void seedStock() {
        this.baseIngredientRepository.save(new BaseIngredientInStock.Builder(++DefaultBaseIngredientService.id, BaseIngredient.ESPRESSO_SHOT, 20).build());
        this.baseIngredientRepository.save(new BaseIngredientInStock.Builder(++DefaultBaseIngredientService.id, BaseIngredient.BLACK_COFFEE, 20).build());
    }

    public List<BaseIngredientInStock> getAllBaseIngredientsInStock() {
        return this.baseIngredientRepository.findAll();
    }

    @Override
    public void decrementBaseIngredient(List<BaseIngredientOnRecipe> baseIngredientToChange) {

        baseIngredientToChange.forEach(baseIngredientOnRecipe -> {
            BaseIngredientInStock ingredient = this.baseIngredientRepository.find(baseIngredientOnRecipe.getBaseIngredient());
            ingredient.setQuantity(ingredient.getQuantity() - baseIngredientOnRecipe.getQuantity());
        });
    }

    @Override
    public List<BaseIngredient> findAll() {
        return new ArrayList<>();
    }

    @Override
    public BaseIngredient find(Integer id) {
        return null;
    }

    @Override
    public BaseIngredient update(BaseIngredient bIngredient) {
        return null;
    }

    @Override
    public BaseIngredient delete(Integer id) {
        return null;
    }
}