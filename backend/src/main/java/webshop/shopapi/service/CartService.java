package webshop.shopapi.service;

import webshop.shopapi.entity.Cart;
import webshop.shopapi.entity.ProductInOrder;
import webshop.shopapi.entity.User;

import java.util.Collection;


public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
