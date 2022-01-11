package com.example.rims.bridge;

import com.example.rims.entity.UserPrivilege;

public abstract class UserRights {
    protected UserOperation userOperation;

    protected UserRights(UserOperation userOperation) {
        this.userOperation = userOperation;
    }

    abstract public void printBridge(UserPrivilege userPrivilege);
}
