package com.example.rims.chainOfResponsibility;

import com.example.rims.entity.User;

public interface UserAuthentication {
    void setNext(UserAuthentication nextInChain);
    void process(User user);
}
