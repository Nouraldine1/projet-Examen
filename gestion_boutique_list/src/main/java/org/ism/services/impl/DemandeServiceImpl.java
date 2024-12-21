package org.ism.services.impl;

import org.ism.entities.Demande;
import org.ism.entities.Client;
import org.ism.entities.enums.EtatDemande;
import org.ism.repositories.IDemandeRepository;
import org.ism.services.IDemandeService;

import java.util.List;

public class DemandeServiceImpl implements IDemandeService {
    private final IDemandeRepository demandeRepository;

    public DemandeServiceImpl(IDemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    @Override
    public Demande save(Demande demande) {
        return demandeRepository.save(demande);
    }

    @Override
    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }

    @Override
    public Demande findById(int id) {
        return demandeRepository.findById(id);
    }

    @Override
    public List<Demande> findAllByClient(Client client) {
        return demandeRepository.findAllByClient(client);
    }

    @Override
    public List<Demande> findAllByClientAndEtat(Client client, EtatDemande etatDemande) {
        return List.of();
    }

    @Override
    public void delete(Demande demande) {
        demandeRepository.delete(demande);
    }

    @Override
    public void deleteById(int id) {
        demandeRepository.deleteById(id);
    }

    @Override
    public List<Demande> findAllByEtat(EtatDemande etat) {
        return demandeRepository.findAllByEtat(etat);
    }

    public void processRequest(Demande demande, EtatDemande etat) {
        demandeRepository.processRequest(demande, etat);
    }

    @Override
    public void update(Demande entity) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
