package org.ism.repositories.impl;

import org.ism.entities.User;
import org.ism.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private final List<User> users = new ArrayList<>();

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public void delete(User user) {
        users.remove(user);
    }

    public void deleteById(int id) {
        users.removeIf(u -> u.getId() == id);
    }

    public void update(User user) {
        int index = users.indexOf(user);
        if (index!= -1) {
            users.set(index, user);
        }
    }

}
