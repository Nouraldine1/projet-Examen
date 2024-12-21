package org.ism.repositories.impl;

import org.ism.entities.Client;
import org.ism.repositories.IClientRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements IClientRepository {
    private final List<Client> clients = new ArrayList<>();


     public Client save(Client client) {
        clients.add(client);
        return client;
     }

     public Client findById(int id) {
         for (Client client: clients) {
             if(client.getId() == id) {
                 return client;
             }
         }
         return null;
     }

     public List<Client> findAll() {
         return new ArrayList<>(clients);
     }

     public void update(Client client) {
         for (int i = 0; i < clients.size(); i++) {
             if(clients.get(i).getId() == client.getId()) {
                 clients.set(i, client);
                 return;
             }
         }
     }

     public void delete(Client client) {
         clients.remove(client);
     }

     public void deleteById(int id) {
         clients.removeIf(c -> c.getId() == id);
     }

    public Client findByTelephone(String telephone) {
         for (Client client: clients) {
             if(client.getTelephone().equals(telephone)) {
                 return client;
             }
         }
         return null;
    }

    public Client findByLogin(String login) {
         for (Client client: clients) {
             if(client.getUser()!= null && client.getUser().getLogin().equals(login)) {
                 return client;
             }
         }
         return null;
    }
}
