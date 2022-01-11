package com.example.rims.builder;

import com.example.rims.entity.User;

public class UserBuilder {

    //Required
    public String userFirstName;
    public String userLastName;
    public String userEmail;
    public String userPassword;

    //Optional
    public String userTitle;
    public String userDepartment;

    public UserBuilder(){}

    public UserBuilder(String userFirstName, String userLastName, String userEmail, String userPassword) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public User build(){
        return new User(this);
    }

}
