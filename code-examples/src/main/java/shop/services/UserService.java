package shop.services;

import shop.models.Cart;
import shop.models.User;

import java.util.List;

/**
 * User: mario
 * Date: 20.10.13
 */
public interface UserService {
    User getUserForId(int id);

    void doStuffToAUser(User user, boolean activate, boolean initialize, Cart cart);

    void getXAmountOfUsers(int x, List<User> users);
}
