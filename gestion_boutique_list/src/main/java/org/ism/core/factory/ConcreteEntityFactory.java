package org.ism.core.factory;


import org.ism.entities.*;
import org.ism.entities.enums.EtatArticle;
import org.ism.entities.enums.EtatDemande;
import org.ism.entities.enums.RoleUser;
import org.ism.entities.enums.StatutDette;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ConcreteEntityFactory extends EntityFactory {
    @Override
    public IEntity createEntity(String type, Map<String, Object> params) {
        return switch (type) {
            case "Admin" -> new Admin(
                    (String) params.get("noms"),
                    (String) params.get("prenoms"),
                    (String) params.get("telephone"),
                    (User) params.get("user")
            );
            case "Boutiquier" -> new Boutiquier(
                    (String) params.get("noms"),
                    (String) params.get("prenoms"),
                    (String) params.get("telephone"),
                    (User) params.get("user")
            );
            case "Client" -> new Client(
                    (String) params.get("noms"),
                    (String) params.get("prenoms"),
                    (String) params.get("telephone"),
                    (String) params.get("adresse"),
                    (List<Demande>) params.get("demandes"),
                    (List<Dette>) params.get("dettes"),
                    (User) params.get("user")
            );
            case "User" -> new User(
                    (String) params.get("login"),
                    (String) params.get("password"),
                    (RoleUser) params.get("role"),
                    (Boolean) params.get("isActive")
            );
            case "Article" -> new Article(
                    (String) params.get("libelle"),
                    (Double) params.get("prixUnitaire"),
                    (Integer) params.get("quantiteStock"),
                    (EtatArticle) params.get("etat")
            );
            case "Demande" -> new Demande(
                    (LocalDate) params.get("date"),
                    (Double) params.get("montant"),
                    (List<DetailsDemande>) params.get("details"),
                    (Client) params.get("client"),
                    (EtatDemande) params.get("etat")
            );
            case "Dette" -> new Dette(
                    (LocalDate) params.get("date"),
                    (Double) params.get("montantTotal"),
                    (Double) params.get("montantVerser"),
                    (List<DetailsDetteArticle>) params.get("detailsArticles"),
                    (List<DetailsDettePayment>) params.get("detailsPayments"),
                    (StatutDette) params.get("statut"),
                    (Client) params.get("client")
            );
            case "Payment" -> new Payment(
                    (LocalDate) params.get("date"),
                    (Double) params.get("montant"),
                    (Dette) params.get("dette")
            );
            case "DetailsDemande" -> new DetailsDemande(
                    (Integer) params.get("quantite"),
                    (Article) params.get("article"),
                    (Demande) params.get("demande")
            );
            case "DetailsDetteArticle" -> new DetailsDetteArticle(
                    (Integer) params.get("quantite"),
                    (Article) params.get("article"),
                    (Dette) params.get("dette")
            );
            case "DetailsDettePayment" -> new DetailsDettePayment(
                    (LocalDate) params.get("date"),
                    (Payment) params.get("payment"),
                    (Dette) params.get("dette")
            );
            default -> throw new IllegalArgumentException("Type non valide : " + type);
        };
    }
}
