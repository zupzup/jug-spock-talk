package shop.services.impl;

import shop.models.Cart;
import shop.models.Product;
import shop.models.User;
import shop.services.SessionService;

import java.util.ArrayList;

/**
 * User: mario
 * Date: 20.10.13
 */
public class SesseionServiceImpl implements SessionService {

    @Override
    public User getCurrentUser() {
        return new User();
    }

    @Override
    public Cart getSessionCart() {
        Cart cart = new Cart();
        cart.setProducts(new ArrayList<Product>());
        return cart;
    }

    @Override
    public void setSessionCart(Cart cart) {
        // set the session cart
    }

}
