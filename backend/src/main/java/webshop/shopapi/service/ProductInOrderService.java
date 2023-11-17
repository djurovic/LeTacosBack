package webshop.shopapi.service;

import webshop.shopapi.entity.ProductInOrder;
import webshop.shopapi.entity.User;


public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
