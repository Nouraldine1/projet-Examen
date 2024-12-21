package org.ism.views;

import org.ism.core.utils.MessagePrinter;
import org.ism.entities.*;
import org.ism.entities.enums.StatutDette;

import java.time.LocalDate;
import java.util.*;

public abstract class DetteView {
    private static final Scanner scanner = new Scanner(System.in);

    private DetteView() {}

    public static int menu() {
        MessagePrinter.printMessage("Menu Dette");
        MessagePrinter.printMessage("1. Enregistrer une dette");
        MessagePrinter.printMessage("2. Lister toutes les dettes");
        MessagePrinter.printMessage("3. Lister les dettes soldées");
        MessagePrinter.printMessage("4. Lister les dettes non soldées");
        MessagePrinter.printMessage("5. Lister les dettes d'un client");
        MessagePrinter.printMessage("6. Voir les détails d'une dette");
        MessagePrinter.printMessage("7. Enregistrer un paiement pour une dette");
        MessagePrinter.printMessage("0. Précédent");
        MessagePrinter.printMessage("Faites votre choix : ");

        return Integer.parseInt(scanner.nextLine());
    }

    public static int menuDettesClient() {
        MessagePrinter.printMessage("Menu Dette");
        MessagePrinter.printMessage("1. Lister les dettes");
        MessagePrinter.printMessage("2. Lister les dettes soldées");
        MessagePrinter.printMessage("3. Lister les dettes non soldées");
        MessagePrinter.printMessage("4. Voir les détails d'une dette");
        MessagePrinter.printMessage("0. Précédent");
        MessagePrinter.printMessage("Faites votre choix : ");

        return Integer.parseInt(scanner.nextLine());
    }

    public static Dette create(List<Client> clients, List<Article> articles) {
        LocalDate date = LocalDate.now();
        double montantTotal = 0;
        double montantVerser = 0;
        List<DetailsDetteArticle> detailsArticles = new ArrayList<>();
        List<DetailsDettePayment> detailsPayments = new ArrayList<>();

        MessagePrinter.printMessage("À qui est destiné cette dette ? \nVeuillez saisir le numéro de téléphone du client:");

        Client client = ClientView.searchByTelephone(clients);
        if(client != null) {
            MessagePrinter.printMessage("Client trouvé : " + client.getPrenoms() + " " + client.getNoms());

            MessagePrinter.printMessage("Combien d'articles voulez-vous ajouter dans la dette ?");
            int nombreArticles;

            // Validation de l'entrée du nombre d'articles
            while (true) {
                try {
                    nombreArticles = Integer.parseInt(scanner.nextLine());
                    if (nombreArticles <= 0) {
                        MessagePrinter.printMessage("Le nombre d'articles doit être supérieur à zéro. Réessayez :");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    MessagePrinter.printMessage("Entrée invalide. Veuillez entrer un nombre valide.");
                }
            }

            for (int i = 0; i < nombreArticles; ) {
                // Saisie du libelle et retourne une valeur
                Article article = ArticleView.search(articles);

                if (article != null) {
                    MessagePrinter.printMessage("Saisissez la quantité voulue de l'article :");
                    int quantiteArticle;

                    // Validation de la quantité demandée
                    while (true) {
                        try {
                            quantiteArticle = Integer.parseInt(scanner.nextLine());
                            if (quantiteArticle <= 0) {
                                MessagePrinter.printMessage("La quantité doit être supérieure à zéro. Réessayez :");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            MessagePrinter.printMessage("Entrée invalide. Veuillez entrer un nombre valide.");
                        }
                    }

                    // Vérification du stock disponible
                    if (article.getQuantiteStock() >= quantiteArticle) {
                        // Details des articles de la dette
                        DetailsDetteArticle detailsArticle = new DetailsDetteArticle(quantiteArticle, article, null) ;

                        detailsArticles.add(detailsArticle);

                        // Calcul du montant de la dette
                        montantTotal += detailsArticle.getQuantite() * detailsArticle.getArticle().getPrixUnitaire();

                        // Diminution du stock de l'article
                        article.setQuantiteStock(article.getQuantiteStock() - quantiteArticle);

                        MessagePrinter.printMessage("Article ajouté !");

                        i++; // Incrémenter le compteur seulement si l'article est validé et ajouté
                    } else {
                        MessagePrinter.printMessage("La quantité voulue de cet article n'est pas disponible en stock ! Veuillez choisir un autre article ou une quantité valide.");
                    }
                } else {
                    MessagePrinter.printMessage("Cet article n'est pas disponible en stock ! Veuillez saisir un autre article.");
                }
            }

        } else {
            MessagePrinter.printMessage("Aucun client trouvé avec ce téléphone. Impossible d'ajouter une dette !");
            return null;
        }


        if(!detailsArticles.isEmpty()) {
            // Construction de la dette
            Dette nouvelleDette = new Dette(date, montantTotal, montantVerser, detailsArticles, detailsPayments, StatutDette.NON_SOLDEE, client);

            // Mise à jour de la dette dans chaque détailsArticle
            for (DetailsDetteArticle detailsDetteArticle: detailsArticles) {
                detailsDetteArticle.setDette(nouvelleDette);
            }

            return nouvelleDette;

        } else {
            MessagePrinter.printMessage("Aucun article n'a été ajouté à la dette. Dette non enregistrée !");
            return null;
        }
    }

    public static void show(List<Dette> dettes) {
        MessagePrinter.printMessage("===== Liste des dettes =====");

        if(dettes.isEmpty()) {
            MessagePrinter.printMessage("Aucune dette n'est enregistrée.");
        } else {
            for (Dette dette : dettes) {
                MessagePrinter.printParameter(dette);
            }
        }
    }

    public static void showByStatut(List<Dette> dettes, String statut) {
        MessagePrinter.printMessage("===== Liste des dettes " + "\""+ statut + "\" =====");

        if(dettes.isEmpty()) {
            MessagePrinter.printMessage("Aucune dette " + "\"" + statut + "\" n'est enregistrée.");
        } else {
            for (Dette dette : dettes) {
                MessagePrinter.printParameter(dette);
            }
        }
    }

    public static void showByClient(List<Dette> dettes,  Client client) {
        MessagePrinter.printMessage("Liste des dettes du client : " + client.getPrenoms() + " " + client.getNoms());

        if(dettes.isEmpty()) {
            MessagePrinter.printMessage("Aucune dette n'est enregistrée.");
        } else {
            for (Dette dette : dettes) {
                MessagePrinter.printParameter(dette);
            }
        }
    }

    public static int inputIdentifiant() {
        MessagePrinter.printMessage("Veuillez saisir l'identifiant de la dette :");
        int id;

        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    MessagePrinter.printMessage("L'identifiant doit être supérieur à zéro. Réessayez :");
                    continue;
                }
                return id;
            } catch (NumberFormatException e) {
                MessagePrinter.printMessage("Entrée invalide. Veuillez entrer un nombre valide.");
            }
        }
    }

}

