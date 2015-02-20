package shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import shop.models.Product;
import shop.services.ProductService;
import shop.services.SpecialOfferService;
import shop.services.UserService;

import java.util.List;

/**
 * User: mario
 * Date: 20.10.13
 */
public class ProductServiceImpl implements ProductService {

    @Autowired
    UserService userService;

    @Autowired
    SpecialOfferService specialOfferService;

    @Override
    public Product getProductForId(int id) {
        // do fancy database stuff
        return new Product();
    }

    @Override
    public void setOfferFlagForProducts(List<Product> products) {
        for(Product p : products) {
            p.setSpecialOffer(specialOfferService.getOfferFlagForProduct(p));
        }
    }
}
