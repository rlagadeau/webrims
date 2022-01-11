package com.example.rims.controller;

import com.example.rims.dao.JPAConfigurations;
import com.example.rims.dao.UserDAO;
import com.example.rims.entity.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("signup")
public class SignUpController {

    JPAConfigurations jpaConfigurations = new JPAConfigurations();

    private final UserDAO userDAO = new UserDAO(jpaConfigurations.getEntityManager());

    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String signup(User user){
        return userDAO.insertUser(user);
    }
}
