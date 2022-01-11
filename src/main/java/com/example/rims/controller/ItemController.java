package com.example.rims.controller;

import com.example.rims.dao.JPAConfigurations;
import com.example.rims.entity.Item;
import com.example.rims.dao.ItemDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("item")
public class ItemController {

    JPAConfigurations jpaConfigurations = new JPAConfigurations();

    private final ItemDAO itemDAO = new ItemDAO(jpaConfigurations.getEntityManager());

    @Path("/getItems")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> getItems(){
        return itemDAO.selectItems();
    }

    @Path("/getItem")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Item getItem(Item item){
        return itemDAO.selectItem(item.getItemId());
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addItem(Item item){
        return itemDAO.insertItem(item);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateItem(Item item){
        return itemDAO.updateItem(item);
    }

    @Path("/delete")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteItem(Item item){
        return itemDAO.deleteItem(item);
    }

}
