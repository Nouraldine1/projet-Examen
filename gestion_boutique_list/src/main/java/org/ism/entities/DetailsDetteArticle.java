package org.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ism.core.factory.IEntity;


@Data
@AllArgsConstructor
public class DetailsDetteArticle implements IEntity {
    private int id;
    private int quantite;
    private Article article;
    private Dette dette;

    private static int cpt;

    public DetailsDetteArticle() {
        cpt++;
        this.id = cpt;
    }

    public DetailsDetteArticle(final int quantite, final Article article, final Dette dette) {
        cpt++;
        this.id = cpt;
        this.article = article;
        this.quantite = quantite;
        this.dette = dette;
    }

    @Override
    public String toString() {
        return "detailsArticle{" +
                "id=" + id +
                ", article=" + article.getLibelle() +
                ", quantite=" + quantite +
                ", prix=" + article.getPrixUnitaire() * quantite +
                ", detteID=" + dette.getId() +
                '}';
    }


}

