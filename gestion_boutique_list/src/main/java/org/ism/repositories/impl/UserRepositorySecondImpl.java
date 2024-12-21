package org.ism.repositories.impl;

import org.ism.core.factory.IEntity;
import org.ism.repositories.IUserRepositorySecond;

import java.util.ArrayList;
import java.util.List;

public class UserRepositorySecondImpl implements IUserRepositorySecond {
    private final List<IEntity> iEntities = new ArrayList<>();

    @Override
    public IEntity save(IEntity entity) {
        iEntities.add(entity);
        return entity;
    }

    @Override
    public IEntity findById(int id) {
        return null;
    }

    @Override
    public List<IEntity> findAll() {
        return new ArrayList<>(iEntities);
    }

    @Override
    public void update(IEntity entity) {

    }

    @Override
    public void delete(IEntity entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}
