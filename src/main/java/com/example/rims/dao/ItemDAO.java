package com.example.rims.dao;

import com.example.rims.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ItemDAO {
    private final EntityManager entityManager;

    public ItemDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String insertItem(Item item) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
            return "Item added successfully";
        }catch (Exception e){
            e.printStackTrace();
            return "Item addition failed: " + e.toString();
        }
    }

    public String updateItem(Item item) {
        try {
            entityManager.getTransaction().begin();
            String sql = "update Item i set i.itemCode = :itemCode, i.itemDescription = :itemDescription, i.itemBrand = :itemBrand where i.itemId = :itemId";
            Query query = entityManager.createQuery(sql);
            query.setParameter("itemId", item.getItemId());
            query.setParameter("itemCode", item.getItemCode());
            query.setParameter("itemDescription", item.getItemDescription());
            query.setParameter("itemBrand", item.getItemBrand());
            int updated = query.executeUpdate();
            entityManager.getTransaction().commit();
            return "Item update succeeded";
        }catch (Exception e){
            e.printStackTrace();
            return "Item update failed: " + e.toString();
        }
    }

    public String deleteItem(Item item) {
        try {
            entityManager.getTransaction().begin();
            String sql = "delete from Item i where i.itemId = :itemId";
            Query query = entityManager.createQuery(sql);
            query.setParameter("itemId", item.getItemId());
            int deleted = query.executeUpdate();
            entityManager.getTransaction().commit();
            return "Item deletion succeeded";
        }catch (Exception e){
            e.printStackTrace();
            return "Item deletion failed: " + e.toString();
        }
    }

    public Item selectItem(long itemId) {
        entityManager.getTransaction().begin();
        String jpql = "select i from Item i where i.itemId = :itemId";
        TypedQuery<Item> query = entityManager.createQuery(jpql, Item.class);
        query.setParameter("itemId", itemId);
        Item item = query.getSingleResult();
        entityManager.getTransaction().commit();
        return item;
    }

    public List<Item> selectItems() {
        entityManager.getTransaction().begin();
        String jpql = "select i from Item i";
        TypedQuery<Item> query = entityManager.createQuery(jpql, Item.class);
        List<Item> item = query.getResultList();
        entityManager.getTransaction().commit();
        return item;
    }

    public void selectItemExpMin3() {
        entityManager.getTransaction().begin();
        String jpql = "select i.itemCode, i.itemDescription from Item i where i.itemExpirationDate > '2019-10-1'";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> item = query.getResultList();
        entityManager.getTransaction().commit();
        System.out.println("Below are the items with an expiration date less than three months: ");
        System.out.println("\r");
        for (Object[] i : item) {
            System.out.println("itemCode: "+i[0]+ " - " + "itemDescription: "+i[1]);
        }
    }

    public void selectItemExpMax() {
        entityManager.getTransaction().begin();
        String jpql = "select i.itemCode, i.itemDescription from Item i where i.itemExpirationDate < '2019-10-1'";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> item = query.getResultList();
        entityManager.getTransaction().commit();
        System.out.println("Below are the items with an expiration date greater than three months: ");
        System.out.println("\r");
        for (Object[] i : item) {
            System.out.println("itemCode: "+i[0]+ " - " + "itemDescription: "+i[1]);
        }
    }
}
