package org.ism.services.impl;

import org.ism.core.factory.IEntity;
import org.ism.repositories.IUserRepositorySecond;
import org.ism.services.IUserServiceSecond;

import java.util.List;

public class UserServiceSecondImpl implements IUserServiceSecond {
    private final IUserRepositorySecond userRepositorySecond;

    public UserServiceSecondImpl(IUserRepositorySecond userRepositorySecond) {
        this.userRepositorySecond = userRepositorySecond;
    }

    @Override
    public IEntity save(IEntity entity) {
        return userRepositorySecond.save(entity);
    }

    @Override
    public IEntity findById(int id) {
        return userRepositorySecond.findById(id);
    }

    @Override
    public List<IEntity> findAll() {
        return userRepositorySecond.findAll();
    }

}
