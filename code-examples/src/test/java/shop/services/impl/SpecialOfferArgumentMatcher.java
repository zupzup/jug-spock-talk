package shop.services.impl;

import org.mockito.ArgumentMatcher;
import shop.models.Product;

/**
 * User: mario
 * Date: 20.10.13
 */
public class SpecialOfferArgumentMatcher extends ArgumentMatcher<Product> {

    @Override
    public boolean matches(Object o) {
        return ((Product)o).getName().startsWith("offer");
    }
}
