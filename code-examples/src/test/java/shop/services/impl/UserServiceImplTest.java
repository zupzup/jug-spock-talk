package shop.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import shop.models.Cart;
import shop.models.User;
import shop.services.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * User: mario
 * Date: 20.10.13
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    UserService userService;

    @Mock
    Cart cartinator;

    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl();
    }

    @Test
    public void testFlags() throws Exception {
        User user = mock(User.class);
        Cart cart = mock(Cart.class);

        userService.doStuffToAUser(user, false, false, cart);

        verify(user, never()).initialize();
        verify(user, never()).activate();
        verify(user, times(1)).updateFlags();
        verify(cart, times(1)).setOwner((User)any());
    }

    @Test
    public void testFlagsFalseTrue() throws Exception {
        User user = mock(User.class);
        Cart cart = mock(Cart.class);

        userService.doStuffToAUser(user, false, true, cart);

        verify(user, times(1)).initialize();
        verify(user, never()).activate();
        verify(user, times(2)).updateFlags();
        verify(cart, times(1)).setOwner((User)any());
    }

    @Test
    public void testFlagsTrueFalse() throws Exception {
        User user = mock(User.class);
        Cart cart = mock(Cart.class);

        userService.doStuffToAUser(user, true, false, cart);

        verify(user, never()).initialize();
        verify(user, times(1)).activate();
        verify(user, times(2)).updateFlags();
        verify(cart, times(1)).setOwner((User)any());
    }

    @Test
    public void testFlagsTrueTrue() throws Exception {
        User user = mock(User.class);
        Cart cart = mock(Cart.class);

        userService.doStuffToAUser(user, true, true, cart);

        verify(user, times(1)).initialize();
        verify(user, times(1)).activate();
        verify(user, times(3)).updateFlags();
        verify(cart, times(1)).setOwner((User)any());
    }

    @Test
    public void testFlagsTrueTrueInOrder() throws Exception {
        User user = mock(User.class);
        Cart cart = mock(Cart.class);

        InOrder inOrder = inOrder(user, cart);

        userService.doStuffToAUser(user, true, true, cart);

        inOrder.verify(user, times(1)).initialize();
        inOrder.verify(user, times(1)).updateFlags();

        inOrder.verify(user, times(1)).activate();
        inOrder.verify(user, times(1)).updateFlags();

        inOrder.verify(cart, times(1)).setOwner((User)any());
        inOrder.verify(user, times(1)).updateFlags();
        verifyNoMoreInteractions(cart);
    }

    @Test
    public void testNullUser() throws Exception {
        User user = null;
        Cart cart = mock(Cart.class);

        userService.doStuffToAUser(user, true, true, cart);

        verifyZeroInteractions(cart);
    }

    @Test
    public void testNullCart() throws Exception {
        User user = mock(User.class);
        Cart cart = null;

        userService.doStuffToAUser(user, true, true, cart);

        verify(user, timeout(3000).atLeast(5)).initialize();
    }

    @Test
    public void testCounts() throws Exception {
        ArrayList mockList = mock(ArrayList.class);
        userService.getXAmountOfUsers(3, mockList);

        verify(mockList, atLeast(3)).add(any());
        verify(mockList, times(3)).add(any());
        verify(mockList, atMost(3)).add(any());
    }

}
