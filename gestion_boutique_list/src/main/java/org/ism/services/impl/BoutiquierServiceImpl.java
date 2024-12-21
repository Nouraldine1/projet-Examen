package org.ism.services.impl;

import org.ism.entities.Boutiquier;
import org.ism.repositories.IBoutiquierRepository;
import org.ism.services.IBoutiquierService;

import java.util.List;

public class BoutiquierServiceImpl implements IBoutiquierService {
    private final IBoutiquierRepository boutiquierRepository;

    public BoutiquierServiceImpl(IBoutiquierRepository boutiquierRepository) {
        this.boutiquierRepository = boutiquierRepository;
    }

    @Override
    public Boutiquier save(Boutiquier boutiquier) {
        return boutiquierRepository.save(null);
    }

    @Override
    public Boutiquier findById(int id) {
        return boutiquierRepository.findById(id);
    }

    @Override
    public List<Boutiquier> findAll() {
        return boutiquierRepository.findAll();
    }

    @Override
    public void update(Boutiquier boutiquier) {
        boutiquierRepository.update(boutiquier);
    }

    @Override
    public void delete(Boutiquier boutiquier) {
        boutiquierRepository.delete(boutiquier);
    }

    @Override
    public void deleteById(int id) {
        boutiquierRepository.deleteById(id);
    }

    @Override
    public Boutiquier findByLogin(String login) {
        return boutiquierRepository.findByLogin(login);
    }
}
