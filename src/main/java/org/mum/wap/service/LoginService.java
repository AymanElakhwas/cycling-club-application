package org.mum.wap.service;

import org.mum.wap.dao.UserDao;
import org.mum.wap.model.User;

/**
 * @Author Elham
 * @Date 04/23/2018
 * This service class is responsible to check the credential of user for login
 *
 */
public class LoginService {

    public User checkCredential(String username, String password) {

        User user = UserDao.getUser(username, password);

        return user;
    }
}
