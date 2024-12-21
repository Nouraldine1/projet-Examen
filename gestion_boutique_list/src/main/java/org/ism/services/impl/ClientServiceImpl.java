package org.ism.services.impl;

import org.ism.entities.*;
import org.ism.repositories.IClientRepository;
import org.ism.services.IClientService;

import java.util.List;

public class ClientServiceImpl implements IClientService {
    private final IClientRepository clientRepository;

    public ClientServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void update(Client client) {
        clientRepository.update(client);
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findClientByTelephone(String telephone) {
        return clientRepository.findByTelephone(telephone);
    }

    @Override
    public Client findByLogin(String login) {
        return clientRepository.findByLogin(login);
    }


}
