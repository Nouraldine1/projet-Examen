package org.ism.repositories;

import org.ism.core.IRepository;
import org.ism.entities.Client;
import org.ism.entities.Dette;
import org.ism.entities.enums.StatutDette;

import java.util.List;

public interface IDetteRepository extends IRepository<Dette> {
    List<Dette> findAllByClient(Client client);
    List<Dette> findAllByClientAndStatut(Client client, StatutDette statutDette);
    List<Dette> findAllByStatut(StatutDette statutDette);
}
