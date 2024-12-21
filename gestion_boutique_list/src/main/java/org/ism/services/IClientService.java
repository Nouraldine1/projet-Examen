package org.ism.services;

import org.ism.core.IRepository;
import org.ism.core.IService;
import org.ism.entities.Client;

public interface IClientService extends IRepository<Client>, IService<Client> {
    Client findClientByTelephone(String telephone);
}
