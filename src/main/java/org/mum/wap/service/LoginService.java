package org.mum.wap.service;

import org.mum.wap.dao.UserDao;
import org.mum.wap.model.User;

public class LoginService {

    public boolean checkCredential(String username, String password) {

        User user = UserDao.getUser(username, password);

        return (user != null) ? true : false;
    }
}
