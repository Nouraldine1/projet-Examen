package org.ism.services;

import org.ism.core.IRepository;
import org.ism.entities.*;
import org.ism.entities.enums.StatutDette;

import java.util.List;

public interface IDetteService extends IRepository<Dette> {
    List<Dette> findAllByStatut(StatutDette statutDette);
    List<Dette> findAllByClient(Client client);
    List<Dette> findAllByClientAndStatut(Client client, StatutDette statutDette);
}
