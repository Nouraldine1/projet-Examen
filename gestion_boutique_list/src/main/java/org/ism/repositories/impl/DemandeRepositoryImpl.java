package org.ism.repositories.impl;

import org.ism.entities.Client;
import org.ism.entities.Demande;
import org.ism.entities.enums.EtatDemande;
import org.ism.repositories.IDemandeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemandeRepositoryImpl implements IDemandeRepository {
    private final List<Demande> demandes = new ArrayList<>();

    @Override
    public Demande save(Demande demande) {
        demandes.add(demande);
        return demande;
    }

    @Override
    public List<Demande> findAll() {
        return new ArrayList<>(demandes);
    }

    @Override
    public void update(Demande demande) {
        for (int i = 0; i < demandes.size(); i++) {
            if(demandes.get(i).getId() == demande.getId()) {
                demandes.set(i, demande);
                return;
            }
        }
    }

    @Override
    public Demande findById(int id) {
        for (Demande demande : demandes) {
            if (demande.getId() == id) {
                return demande;
            }
        }
        return null;
    }

    @Override
    public void delete(Demande demande) {
        demandes.remove(demande);
    }

    @Override
    public void deleteById(int id) {
        demandes.removeIf(d -> d.getId() == id);
    }

    @Override
    public List<Demande> findAllByEtat(EtatDemande etat) {
        return demandes.stream()
                .filter(demande -> demande.getEtat() == etat)
                .collect(Collectors.toList());
    }

    @Override
    public List<Demande> findAllByClient(Client client) {
        List<Demande> demandesClient = new ArrayList<>();
        for (Demande demande: demandes) {
            if(demande.getClient().equals(client)) {
                demandesClient.add(demande);
            }
        }
        return demandesClient;
    }

    @Override
    public List<Demande> findAllByClientAndEtat(Client client, EtatDemande etatDemande) {
        return List.of();
    }

    @Override
    public void processRequest(Demande demande, EtatDemande etat) {
        demande.setEtat(etat);
    }
}
