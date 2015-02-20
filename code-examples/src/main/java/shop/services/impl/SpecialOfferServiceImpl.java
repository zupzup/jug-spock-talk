package shop.services.impl;

import shop.models.Product;
import shop.services.SpecialOfferService;

/**
 * User: mario
 * Date: 20.10.13
 */
public class SpecialOfferServiceImpl implements SpecialOfferService {

    @Override
    public boolean getOfferFlagForProduct(Product p) {
        if(p.getName() != null && p.getName().startsWith("offer")) {
            return true;
        } else {
            return false;
        }
    }

}
