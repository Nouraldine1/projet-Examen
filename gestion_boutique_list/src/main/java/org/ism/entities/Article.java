package org.ism.entities;

import org.ism.core.factory.IEntity;
import org.ism.entities.enums.EtatArticle;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article implements IEntity {
    private int id;
    private String libelle;
    private double prixUnitaire;
    private int quantiteStock;
    private EtatArticle etat;

    private static int cpt;

    public Article() {
        cpt++;
        this.id = cpt;
    }

    // Constructeur sans id pour l'auto-incrémentation
    public Article(final String libelle, final double prixUnitaire, final int quantiteStock, final EtatArticle etat) {
        cpt++;
        this.id = cpt;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.quantiteStock = quantiteStock;
        this.etat = etat;
    }
    
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                ", quantiteStock=" + quantiteStock +
                ", etat=" + etat.getValue() +
                '}';
    }
}
