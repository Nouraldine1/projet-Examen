package org.ism.repositories;

import org.ism.core.IRepository;
import org.ism.entities.Client;

public interface IClientRepository extends IRepository<Client> {
    Client findByTelephone(String telephone);
    Client findByLogin(String login);
}
