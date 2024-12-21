package org.ism.core;

import org.ism.entities.User;

public interface HasUser {
    void setUser(User user);
    User getUser();
}
