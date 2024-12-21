package org.ism.core;

public interface IService<T> {
    T findByLogin(String login);
}
