package org.ism.views;

import org.ism.core.factory.ConcreteEntityFactory;
import org.ism.core.factory.EntityFactory;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Article;
import org.ism.entities.Client;
import org.ism.entities.Demande;
import org.ism.entities.DetailsDemande;
import org.ism.entities.enums.EtatDemande;

import java.time.LocalDate;
import java.util.*;

public abstract class DemandeView {
    private static final Scanner scanner = new Scanner(System.in);

    private DemandeView() {}

    public static int menu() {
        MessagePrinter.printMessage("Menu Demande:");
        MessagePrinter.printMessage("1. Lister toutes les demandes");
        MessagePrinter.printMessage("2. Lister les demandes en cours");
        MessagePrinter.printMessage("3. Lister les demandes rejetées");
        MessagePrinter.printMessage("4. Lister les demandes acceptées");
        MessagePrinter.printMessage("5. Traiter une demande");
        MessagePrinter.printMessage("0. Précédent");
        MessagePrinter.printMessage("Faites votre choix : ");

        return Integer.parseInt(scanner.nextLine());
    }

    public static int menuClient() {
        MessagePrinter.printMessage("Menu Demande:");
        MessagePrinter.printMessage("1. Enregistrer une demande");
        MessagePrinter.printMessage("2. Lister toutes les demandes");
        MessagePrinter.printMessage("3. Lister les demandes en cours");
        MessagePrinter.printMessage("4. Lister les demandes rejetées");
        MessagePrinter.printMessage("5. Lister les demandes acceptées");
        MessagePrinter.printMessage("6. Voir les détails d'une demandes");
        MessagePrinter.printMessage("0. Quitter");
        MessagePrinter.printMessage("Faites votre choix : ");

        return Integer.parseInt(scanner.nextLine());
    }

    public static Demande create(List<Article> articles, Client client) {
        int nombreArticles = ArticleView.getNombreArticles();

        double montant = 0;
        List<DetailsDemande> detailsDemandes = new ArrayList<>();
        List<Demande> demandes = client.getDemandes();

        for (int i = 0; i < nombreArticles;) {
            Article article = ArticleView.search(articles);
            if (article != null) {
                int quantite = ArticleView.getQuantiteArticle();
                if (addArticleToDemande(article, quantite, detailsDemandes)) {
                    montant += article.getPrixUnitaire() * quantite;
                    i++;
                }
            } else {
                MessagePrinter.printMessage("Cet article n'est pas disponible en stock ! Veuillez saisir un autre article.");
            }
        }

        return createDemande(montant, detailsDemandes, client, demandes);
    }

    private static boolean addArticleToDemande(Article article, int quantite, List<DetailsDemande> detailsDemandes) {
        if (article.getQuantiteStock() >= quantite) {
            DetailsDemande details = DetailsDemandeView.create(quantite, article, null);
            detailsDemandes.add(details);
            MessagePrinter.printMessage("Article ajouté au panier !");
            return true;
        } else {
            MessagePrinter.printMessage("La quantité voulue de cet article n'est pas disponible en stock ! Veuillez choisir un autre article ou une quantité valide.");
            return false;
        }
    }

    private static Demande createDemande(double montant, List<DetailsDemande> detailsDemandes, Client client, List<Demande> demandes) {
        if (!detailsDemandes.isEmpty()) {
            EntityFactory factory = new ConcreteEntityFactory();
            Map<String, Object> demandeParams = new HashMap<>();
            demandeParams.put("date", LocalDate.now());
            demandeParams.put("montant", montant);
            demandeParams.put("details", detailsDemandes);
            demandeParams.put("client", client);
            demandeParams.put("etat", EtatDemande.EN_COURS);

            Demande demande = (Demande) factory.createEntity("Demande", demandeParams);

            for (DetailsDemande detail : detailsDemandes) {
                detail.setDemande(demande);
            }

            demandes.add(demande);
            client.setDemandes(demandes);

            return demande;
        } else {
            return null;
        }
    }

    public static void show(List<Demande> demandes) {
        MessagePrinter.printMessage("===== Liste des demandes =====");
        if(demandes.isEmpty()) {
            MessagePrinter.printMessage("Aucune demande trouvée.");
        } else {
            for (Demande demande : demandes) {
                MessagePrinter.printParameter(demande);
            }
        }
    }

    public static Demande search(List<Demande> demandes) {
        int id = inputIdentifiant();

        for(Demande demande: demandes) {
            if(demande.getId() == id) {
                return demande;
            }
        }

        return null;
    }

    public static int subMenuProcess() {
        MessagePrinter.printMessage("1. Rejeter");
        MessagePrinter.printMessage("2. Accepter");
        MessagePrinter.printMessage("0. Quitter");
        MessagePrinter.printMessage("Faites votre choix: ");

        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputIdentifiant() {
        MessagePrinter.printMessage("Veuillez saisir l'Identifiant de la demande à traiter :");
        int id;

        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    MessagePrinter.printMessage("L'Identifiant doit être supérieur à zéro. Réessayez :");
                    continue;
                }
                return id;
            } catch (NumberFormatException e) {
                MessagePrinter.printMessage("Entrée invalide. Veuillez entrer un nombre valide.");
            }
        }
    }

    public static void traiterDemande() {}

}
