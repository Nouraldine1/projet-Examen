package org.ism.entities;

import org.ism.core.factory.IEntity;
import org.ism.entities.enums.EtatDemande;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Demande implements IEntity {
    private int id;
    private LocalDate date = LocalDate.now();
    private double montant;
    private List<DetailsDemande> details = new ArrayList<>();
    private Client client;
    private EtatDemande etat;

    private static int cpt;

    public Demande() {
        cpt++;
        this.id = cpt;
    }

    public Demande(final LocalDate date, final double montant, final List<DetailsDemande> details, final Client client, final EtatDemande etat) {
        cpt++;
        this.id = cpt;
        this.date = date;
        this.montant = montant;
        this.details = details;
        this.client = client;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Demande{" +
                "id=" + id +
                ", date=" + date +
                ", montant=" + montant +
                ", articles=" + details.size() +
                ", etat=" + etat.getValue() +
                ", clientID=" + (client != null ? client.getId() : "null") +
                '}';
    }

    
}
