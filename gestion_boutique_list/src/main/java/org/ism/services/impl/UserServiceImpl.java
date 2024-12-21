package org.ism.services.impl;

import org.ism.core.HasUser;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.User;
import org.ism.repositories.IUserRepository;
import org.ism.services.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public <T extends HasUser> T associerUser(T entity, User user) {

        if (entity != null) {
            entity.setUser(user);
            user.setActive(true);

            userRepository.update(user); // Mise à jour du User
            return entity;
        } else {
            MessagePrinter.printMessage("Entité ou utilisateur introuvable.");
            return null;
        }
    }
}
