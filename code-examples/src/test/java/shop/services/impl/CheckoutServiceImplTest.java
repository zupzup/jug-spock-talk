package shop.services.impl;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import shop.models.Cart;
import shop.models.Product;
import shop.services.ProductService;
import shop.services.SessionService;
import shop.services.UserService;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * User: mario
 * Date: 20.10.13
 */
@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceImplTest {

    CheckoutServiceImpl checkoutService;

    @Mock
    SessionService sessionService;


    @Before
    public void setUp() throws Exception {
        checkoutService = new CheckoutServiceImpl();
        checkoutService.sessionService = sessionService;

    }

    @Test
    @Ignore
    public void testAddToCartWithoutMocking() throws Exception {
        Product product = new Product();
        product.setId(123);

        checkoutService.addToCart(product);
        assertThat(sessionService.getSessionCart().getProducts().get(0).getId(),
                equalTo(123));
    }

    @Test
    public void testAddToCart() throws Exception {
        Cart cart = mock(Cart.class);
        when(sessionService.getSessionCart()).thenReturn(cart);

        Product myProduct = mock(Product.class);
        checkoutService.addToCart(myProduct);
        verify(cart, atLeast(1)).addProduct(myProduct);
    }

    @Test
    public void testAddToCartSpyOnRealObject() throws Exception {
        SesseionServiceImpl sessService = new SesseionServiceImpl();
        SesseionServiceImpl spy = spy(sessService);
        checkoutService.sessionService = spy;

        checkoutService.addToCart(mock(Product.class));
        verify(spy).getSessionCart();
        verify(spy, never()).getCurrentUser();
    }



}
