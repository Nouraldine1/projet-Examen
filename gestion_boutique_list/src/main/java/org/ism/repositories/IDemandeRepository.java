package org.ism.repositories;

import org.ism.core.IRepository;
import org.ism.entities.Client;
import org.ism.entities.Demande;
import org.ism.entities.enums.EtatDemande;

import java.util.List;

public interface IDemandeRepository extends IRepository<Demande> {
    List<Demande> findAllByEtat(EtatDemande etatDemande);
    List<Demande> findAllByClient(Client client);
    List<Demande> findAllByClientAndEtat(Client client, EtatDemande etatDemande);
    void processRequest(Demande demande, EtatDemande etat);
}
