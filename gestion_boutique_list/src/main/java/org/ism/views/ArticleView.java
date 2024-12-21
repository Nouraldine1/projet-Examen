package org.ism.views;

import org.ism.core.factory.ConcreteEntityFactory;
import org.ism.core.factory.EntityFactory;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Article;
import org.ism.entities.enums.EtatArticle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class ArticleView {
    private static final Scanner scanner = new Scanner(System.in);

    private ArticleView(){}

    public static int menu() {
        MessagePrinter.printMessage("Menu Article");
        MessagePrinter.printMessage("1. Enregistrer un article");
        MessagePrinter.printMessage("2. Lister les articles");
        MessagePrinter.printMessage("3. Approvisionnement d'articles");
        MessagePrinter.printMessage("4. Rechercher un article par libelle");
        MessagePrinter.printMessage("0. Précédent");
        MessagePrinter.printMessage("Faites votre choix : ");

        return Integer.parseInt(scanner.nextLine());
    }

    public static Article create() {
        MessagePrinter.printMessage("\n========= Création d'un Article =========");
        MessagePrinter.printMessage("Libelle : ");
        String libelle = scanner.nextLine();
        MessagePrinter.printMessage("Prix Unitaire : ");
        double prixUnitaire = Double.parseDouble(scanner.nextLine());
        MessagePrinter.printMessage("Quantité stock : ");
        int quantiteStock = Integer.parseInt(scanner.nextLine());
        // Mise à jour de l'état de l'article selon la quantité insérée
        EtatArticle etat = (quantiteStock == 0) ? EtatArticle.RUPTURE : EtatArticle.DISPONIBLE;

        EntityFactory factory = new ConcreteEntityFactory();

        Map<String, Object> articleParams = new HashMap<>();
        articleParams.put("libelle", libelle);
        articleParams.put("prixUnitaire", prixUnitaire);
        articleParams.put("quantiteStock", quantiteStock);
        articleParams.put("etat", etat);

        return (Article) factory.createEntity("Article", articleParams);
    }

    public static void showByLibelle(Article article) {
        if(article != null) {
            MessagePrinter.printParameter(article);
        } else {
            MessagePrinter.printMessage("Aucun article trouvé avec ce libellé.");
        }
    }

    public static void show(List<Article> articles) {
        if(articles.isEmpty()) {
            MessagePrinter.printMessage("Aucun article trouvé");
        } else {
            MessagePrinter.printMessage("\n========== Liste des Articles ==========");
            for (Article article : articles) {
                MessagePrinter.printParameter(article);
            }
        }

    }

    public static Article search(List<Article> articles) {
        String libelle = inputLibelle();

        for(Article article: articles) {
            if(article.getLibelle().equalsIgnoreCase(libelle)) {
                return article;
            }
        }

        return null;
    }

    public static int inputIdentifiant() {
        MessagePrinter.printMessage("Veuillez saisir l'identifiant de l'article : ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputLibelle() {
        MessagePrinter.printMessage("Veuillez saisir le libelle de l'article : ");
        return scanner.nextLine();
    }

    public static int getQuantiteArticle() {
        MessagePrinter.printMessage("Saisissez la quantité voulue de l'article :");
        int quantite;

        // Validation de la quantité demandée
        while (true) {
            try {
                quantite = Integer.parseInt(scanner.nextLine());
                if (quantite <= 0) {
                    MessagePrinter.printMessage("La quantité doit être supérieure à zéro. Réessayez :");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                MessagePrinter.printMessage("Entrée invalide. Veuillez entrer un nombre valide.");
            }
        }

        return quantite;
    }

    public static int getNombreArticles() {
        int nombreArticles;
        MessagePrinter.printMessage("Combien d'articles voulez-vous ajouter dans la demande ?");
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
        return nombreArticles;
    }

}