package shop.services;

import shop.models.Product;

/**
 * User: mario
 * Date: 20.10.13
 */
public interface SpecialOfferService {

    boolean getOfferFlagForProduct(Product p);
}
