package org.fantasticcoffee.shop.facade.order;

import org.fantasticcoffee.shop.data.order.OrderRequest;
import org.fantasticcoffee.shop.data.order.OrderResponse;
import org.fantasticcoffee.shop.facade.converter.Converter;
import org.fantasticcoffee.shop.model.Order;
import org.fantasticcoffee.shop.model.ingredient.IngredientOnRecipe;
import org.fantasticcoffee.shop.service.IngredientService;
import org.fantasticcoffee.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultOrderFacade implements OrderFacade {

    @Autowired
    Converter<Order, OrderRequest> orderRequestConverter;
    @Autowired
    Converter<OrderResponse, Order> orderConverter;
    @Autowired
    OrderService orderService;
    @Autowired
    private IngredientService ingredientService;

    @Override
    public OrderResponse getOrderFromOrderResponse(OrderRequest orderRequest) {

        Order order = orderRequestConverter.convert(orderRequest);
        List<IngredientOnRecipe> ingredients = ingredientService.checkIngredientInStockForOrder(order);
        Order placedOrder = orderService.placeOrder(order, ingredients);
        return orderConverter.convert(placedOrder);
    }

    @Override
    public List<OrderResponse> getAll() {
        return this.orderConverter.convertAll(this.orderService.findAll());
    }

    @Override
    public OrderResponse update(Integer id, OrderRequest orderRequest) {

        Order order = this.orderService.update(id, this.orderRequestConverter.convert(orderRequest));
        return orderConverter.convert(order);
    }

    @Override
    public void delete(Integer id) {
        this.orderService.deleteOrder(id);
    }
}