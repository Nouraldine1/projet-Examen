package org.ism.services;

import org.ism.core.HasUser;
import org.ism.core.IRepository;
import org.ism.entities.User;

public interface IUserService extends IRepository<User> {
    <T extends HasUser> T associerUser(T entity, User user);
}
