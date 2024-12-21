package org.ism.services.impl;

import org.ism.entities.*;
import org.ism.entities.enums.StatutDette;
import org.ism.repositories.IDetteRepository;
import org.ism.services.IDetteService;

import java.util.List;

public class DetteServiceImpl implements IDetteService {
    private final IDetteRepository detteRepository;

    public DetteServiceImpl(IDetteRepository detteRepository) {
        this.detteRepository = detteRepository;
    }

    @Override
    public Dette save(Dette dette) {
        return detteRepository.save(dette);
    }

    @Override
    public List<Dette> findAll() {
        return detteRepository.findAll();
    }

    @Override
    public Dette findById(int id) {
        return detteRepository.findById(id);
    }

    @Override
    public void delete(Dette dette) {
        detteRepository.delete(dette);
    }

    @Override
    public void deleteById(int id) {
        detteRepository.deleteById(id);
    }

    @Override
    public void update(Dette dette) {
        detteRepository.update(dette);
    }

    public List<Dette> findAllByClient(Client client) {
        return detteRepository.findAllByClient(client);
    }

    @Override
    public List<Dette> findAllByClientAndStatut(Client client, StatutDette statut) {
        return detteRepository.findAllByClientAndStatut(client, statut);
    }

    public List<Dette> findAllByStatut(StatutDette statutDette) {
        return detteRepository.findAllByStatut(statutDette);
    }
}
