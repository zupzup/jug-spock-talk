package shop.services;

import shop.models.Cart;
import shop.models.User;

/**
 * User: mario
 * Date: 20.10.13
 */
public interface SessionService {
    User getCurrentUser();

    Cart getSessionCart();

    void setSessionCart(Cart cart);
}
