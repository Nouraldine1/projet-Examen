package org.ism.repositories.impl;

import org.ism.entities.Boutiquier;
import org.ism.repositories.IBoutiquierRepository;

import java.util.ArrayList;
import java.util.List;

public class BoutiquierRepositoryImpl implements IBoutiquierRepository {
    private final List<Boutiquier> boutiquiers = new ArrayList<>();

    @Override
    public Boutiquier save(Boutiquier boutiquier) {
        boutiquiers.add(boutiquier);
        return boutiquier;
    }

    @Override
    public List<Boutiquier> findAll() {
        return new ArrayList<>(boutiquiers);
    }

    @Override
    public Boutiquier findById(int id) {
        for (Boutiquier boutiquier : boutiquiers) {
            if (boutiquier.getId() == id) {
                return boutiquier;
            }
        }
        return null;
    }

    @Override
    public void update(Boutiquier boutiquier) {
        int index = boutiquiers.indexOf(boutiquier);
        if (index!= -1) {
            boutiquiers.set(index, boutiquier);
        }
    }

    @Override
    public void delete(Boutiquier boutiquier) {
        boutiquiers.remove(boutiquier);
    }

    @Override
    public void deleteById(int id) {
        boutiquiers.removeIf(b -> b.getId() == id);
    }

    @Override
    public Boutiquier findByLogin(String login) {
        for (Boutiquier boutiquier : boutiquiers) {
            if (boutiquier.getUser() != null && boutiquier.getUser().getLogin().equals(login)) {
                return boutiquier;
            }
        }
        return null;
    }
}
