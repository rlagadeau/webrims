package com.example.rims.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long itemId;

    @Column(unique = true, nullable = false)
    private int itemCode;

    @Column
    private String itemDescription;

    @Column
    private String itemBrand;

    @Column
    private LocalDate itemExpirationDate;

    public Item(){}

    public Item(int itemCode, String itemDescription, String itemBrand, LocalDate itemExpirationDate) {
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.itemBrand = itemBrand;
        this.itemExpirationDate = itemExpirationDate;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public LocalDate getItemExpirationDate() {
        return itemExpirationDate;
    }

    public void setItemExpirationDate(LocalDate itemExpirationDate) {
        this.itemExpirationDate = itemExpirationDate;
    }
}
