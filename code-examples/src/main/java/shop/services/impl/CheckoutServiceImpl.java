package shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import shop.models.Cart;
import shop.models.Product;
import shop.services.CheckoutService;
import shop.services.ProductService;
import shop.services.SessionService;
import shop.services.UserService;

import java.util.ArrayList;

/**
 * User: mario
 * Date: 20.10.13
 */
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    SessionService sessionService;

    @Override
    public void addToCart(Product product) {
        Cart sessionCart = sessionService.getSessionCart();
        if(sessionCart == null) {
            sessionCart = new Cart();

            sessionCart.setOwner(sessionService.getCurrentUser());
            sessionCart.setProducts(new ArrayList<Product>());

            sessionService.setSessionCart(sessionCart);
        }

        sessionCart.addProduct(product);
    }

}
