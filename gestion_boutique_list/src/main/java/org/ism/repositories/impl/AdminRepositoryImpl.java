package org.ism.repositories.impl;

import org.ism.entities.Admin;
import org.ism.repositories.IAdminRepository;

import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements IAdminRepository {
    private final List<Admin> admins = new ArrayList<>();

    @Override
    public Admin save(Admin admin) {
        admins.add(admin);
        return admin;
    }

    @Override
    public List<Admin> findAll() {
        return new ArrayList<>(admins);
    }

    @Override
    public Admin findById(int id) {
        for (Admin admin : admins) {
            if (admin.getId() == id) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public void update(Admin admin) {
        int index = admins.indexOf(admin);
        if (index!= -1) {
            admins.set(index, admin);
        }
    }

    @Override
    public void delete(Admin admin) {
        admins.remove(admin);
    }

    @Override
    public void deleteById(int id) {
        admins.removeIf(a -> a.getId() == id);
    }

    @Override
    public Admin findByLogin(String login) {
        for (Admin admin : admins) {
            if (admin.getUser() != null && admin.getUser().getLogin().equals(login)) {
                return admin;
            }
        }
        return null;
    }
}
