package org.fantasticcoffee.shop.service.impl.factory;

import org.fantasticcoffee.shop.model.StandardCoffee;
import org.fantasticcoffee.shop.model.coffee.CustomizableStandardCoffee;
import org.fantasticcoffee.shop.model.ingredientonrecipe.ExtraIngredientOnRecipe;

import java.util.List;

public class DefaultMachiatto implements StandardCoffeeFactory {

    @Override
    public CustomizableStandardCoffee create(String customerName, List<ExtraIngredientOnRecipe> extraIngredients) {
        return new CustomizableStandardCoffee(customerName, StandardCoffee.MACHIATTO, extraIngredients);
    }
}