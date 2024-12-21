package org.ism.services;

import org.ism.core.factory.IEntity;

import java.util.List;

public interface IUserServiceSecond {
    IEntity save(IEntity entity);
    IEntity findById(int id);
    List<IEntity> findAll();
}
