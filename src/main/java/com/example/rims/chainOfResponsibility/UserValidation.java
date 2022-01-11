package com.example.rims.chainOfResponsibility;

import com.example.rims.dao.JPAConfigurations;
import com.example.rims.dao.UserDAO;
import com.example.rims.entity.User;

public class UserValidation implements UserAuthentication{
    private UserAuthentication nextInChain;

    JPAConfigurations jpaConfigurations = new JPAConfigurations();

    private UserDAO usr = new UserDAO(jpaConfigurations.getEntityManager());

    public void setNext(UserAuthentication c) {
        nextInChain = c;
    }

    public void process(User user) {
        if (usr.UserValidation(user.getUserEmail(), user.getUserPassword())) {
            System.out.println("User is validated!");
        }
        else {
            System.out.println("User is not validated!");
        }
    }
}
