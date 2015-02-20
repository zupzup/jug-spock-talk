package shop.services;

import shop.models.Product;

import java.util.List;

/**
 * User: mario
 * Date: 20.10.13
 */
public interface ProductService {


    Product getProductForId(int id);

    void setOfferFlagForProducts(List<Product> products);
}
