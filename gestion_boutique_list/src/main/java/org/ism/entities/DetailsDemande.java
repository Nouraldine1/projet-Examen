package org.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ism.core.factory.IEntity;


@Data
@AllArgsConstructor
public class DetailsDemande implements IEntity {
    private int id;
    private int quantite;
    private Article article;
    private Demande demande;

    private static int cpt;

    public DetailsDemande() {
        cpt++;
        this.id = cpt;
    }

    public DetailsDemande(int quantite, Article article, Demande demande) {
        cpt++;
        this.id = cpt;
        this.quantite = quantite;
        this.article = article;
        this.demande = demande;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", article=" + article.getLibelle() +
                ", quantite=" + quantite +
                ", montant=" + article.getPrixUnitaire() * quantite +
                ", demande=" + demande.getId() +
                '}';
    }

}
