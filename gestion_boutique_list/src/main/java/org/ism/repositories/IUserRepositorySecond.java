package org.ism.repositories;

import org.ism.core.IRepository;
import org.ism.core.factory.IEntity;

import java.util.List;

public interface IUserRepositorySecond extends IRepository<IEntity> {
    List<IEntity> findAll();
}
