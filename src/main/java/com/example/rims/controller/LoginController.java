package com.example.rims.controller;

import com.example.rims.builder.UserBuilder;
import com.example.rims.dao.JPAConfigurations;
import com.example.rims.dao.UserDAO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginController {

    JPAConfigurations jpaConfigurations = new JPAConfigurations();

    private final UserDAO userDAO = new UserDAO(jpaConfigurations.getEntityManager());

    @Path("/authentication")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean login(UserBuilder userBuilder){
        return userDAO.UserAuthorization(userBuilder.userEmail);
    }
}
