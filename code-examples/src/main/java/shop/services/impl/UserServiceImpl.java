package shop.services.impl;

import shop.models.Cart;
import shop.models.Product;
import shop.models.User;
import shop.services.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mario
 * Date: 20.10.13
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUserForId(int id) {
        // do fancy database stuff
        return new User();
    }

    @Override
    public void doStuffToAUser(User user, boolean activate, boolean initialize, Cart cart) {
        if (user != null && cart != null) {
            if (initialize) {
                user.initialize();
                user.updateFlags();
            }

            if (activate) {
                user.activate();
                user.updateFlags();
            }
            cart.setOwner(user);
            user.updateFlags();
        }
    }

    @Override
    public void getXAmountOfUsers(int x, List<User> users) {
        for(int i = 0; i < x; i++) {
            users.add(getUserForId(i));
        }
    }

}
