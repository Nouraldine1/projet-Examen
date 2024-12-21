package org.ism.services.impl;

import org.ism.entities.Admin;
import org.ism.repositories.IAdminRepository;
import org.ism.services.IAdminService;

import java.util.List;

public class AdminServiceImpl implements IAdminService {
    private final IAdminRepository adminRepository;

    public AdminServiceImpl(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin findById(int id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public void update(Admin admin) {
        adminRepository.update(admin);
    }

    @Override
    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }

    @Override
    public void deleteById(int id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin findByLogin(String login) {
        return adminRepository.findByLogin(login);
    }
}
