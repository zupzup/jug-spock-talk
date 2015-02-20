package shop.services.impl;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import shop.models.Product;
import shop.services.SpecialOfferService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * User: mario
 * Date: 20.10.13
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    SpecialOfferService specialOfferService;

    ProductServiceImpl productService;

    @Before
    public void setUp() throws Exception {
        productService = new ProductServiceImpl();
        productService.specialOfferService = specialOfferService;
    }

    @Test
    public void testSetOfferFlagForProducts() throws Exception {
        List<Product> products = getProducts();

        when(specialOfferService.getOfferFlagForProduct((Product)any())).thenReturn(false);
        when(specialOfferService.getOfferFlagForProduct(argThat(new SpecialOfferArgumentMatcher()))).thenReturn(true);

        productService.setOfferFlagForProducts(products);

        assertThat(products.get(0).isSpecialOffer(), is(false));
        assertThat(products.get(1).isSpecialOffer(), is(true));
        assertThat(products.get(2).isSpecialOffer(), is(false));
        assertThat(products.get(3).isSpecialOffer(), is(true));
    }

    List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(createProduct("prod1"));
        products.add(createProduct("offerprod1"));
        products.add(createProduct("prod2"));
        products.add(createProduct("offerprod2"));
        return products;
    }

    Product createProduct(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}
