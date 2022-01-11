package com.example.rims.entity;

import com.example.rims.builder.UserBuilder;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long userId;

    @Column
    private String userFirstName;

    @Column
    private String userLastName;

    @Column(unique = true, nullable = false)
    private String userEmail;

    @Column
    private String userPassword;

    @Column
    private String userTitle;

    @Column
    private String userDepartment;

    @OneToOne(mappedBy = "user")
    private UserPrivilege userPrivilege;

    public User(){}

    public User(String userFirstName, String userLastName, String userEmail, String userPassword, String userTitle, String userDepartment) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userTitle = userTitle;
        this.userDepartment = userDepartment;
    }

    public User(UserBuilder userBuilder){
        this.userFirstName = userBuilder.userFirstName;
        this.userLastName = userBuilder.userLastName;
        this.userEmail = userBuilder.userEmail;
        this.userPassword = userBuilder.userPassword;
        this.userTitle = userBuilder.userTitle;
        this.userDepartment = userBuilder.userDepartment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public UserPrivilege getUserPrivilege() {
        return userPrivilege;
    }

    public void setUserPrivilege(UserPrivilege userPrivilege) {
        this.userPrivilege = userPrivilege;
    }
}
