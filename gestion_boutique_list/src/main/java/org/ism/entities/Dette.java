package org.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.ism.core.factory.IEntity;
import org.ism.entities.enums.StatutDette;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Dette implements IEntity {
    private int id;
    private LocalDate date = LocalDate.now();
    private double montantTotal;
    private double montantVerser;
    private List<DetailsDetteArticle> detailsArticles = new ArrayList<>();
    private List<DetailsDettePayment> detailsPayments = new ArrayList<>();
    private StatutDette statut;
    private Client client;

    private static int cpt;

    public Dette() {
        cpt++;
        this.id = cpt;
    }

    public Dette(final LocalDate date, final double montantTotal, final double montantVerser, final List<DetailsDetteArticle> detailsArticles, final List<DetailsDettePayment> detailsPayments, final StatutDette statut, final Client client) {
        cpt++;
        this.id = cpt;
        this.date = date;
        this.montantTotal = montantTotal;
        this.montantVerser = montantVerser;
        this.detailsArticles = detailsArticles;
        this.detailsPayments = detailsPayments;
        this.statut = statut;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Dette={" +
                "id=" + id +
                ", date=" + date +
                ", montantTotal=" + montantTotal +
                ", montantVerser=" + montantVerser +
                ", montantRestant=" + (montantTotal - montantVerser) +
                ", articles=" + detailsArticles.size() +
                ", paiements=" + detailsPayments.size() +
                ", statut=" + statut.getValue() +
                ", clientID=" + client.getId() +
                "}";
    }

}