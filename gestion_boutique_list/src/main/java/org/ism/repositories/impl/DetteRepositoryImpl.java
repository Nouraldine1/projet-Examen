package org.ism.repositories.impl;

import org.ism.entities.Client;
import org.ism.entities.Dette;
import org.ism.entities.enums.StatutDette;
import org.ism.repositories.IDetteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetteRepositoryImpl implements IDetteRepository {
    private final List<Dette> dettes = new ArrayList<>();

    @Override
    public Dette save(Dette dette) {
        dettes.add(dette);
        return dette;
    }

    @Override
    public List<Dette> findAll() {
        return new ArrayList<>(dettes);
    }

    @Override
    public void update(Dette entity) {
        int index = dettes.indexOf(entity);
        if (index!= -1) {
            dettes.set(index, entity);
        }
    }

    @Override
    public Dette findById(int id) {
        for (Dette dette : dettes) {
            if (dette.getId() == id) {
                return dette;
            }
        }
        return null;
    }

    @Override
    public void delete(Dette dette) {
        dettes.remove(dette);
    }

    @Override
    public void deleteById(int id) {
        dettes.removeIf(d -> d.getId() == id);
    }

    @Override
    public List<Dette> findAllByClient(Client client) {
        List<Dette> dettesOneClient = new ArrayList<>();
        for (Dette dette : dettes) {
            if (dette.getClient().getId() == client.getId()) {
                dettesOneClient.add(dette);
            }
        }
        return dettesOneClient;
    }

    @Override
    public List<Dette> findAllByClientAndStatut(Client client, StatutDette statutDette) {
        List<Dette> dettesClientByStatut = findAllByClient(client);
        for(Dette detteClient: dettesClientByStatut) {
            if(detteClient.getStatut() != statutDette) {
                dettesClientByStatut.remove(detteClient);
            }
        }

        return dettesClientByStatut;
    }

    @Override
    public List<Dette> findAllByStatut(StatutDette statutDette) {
        return dettes.stream()
                .filter(dette -> dette.getStatut() == statutDette)
                .collect(Collectors.toList());
    }
}
