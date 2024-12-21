package org.ism.views;

import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Article;

import java.util.Scanner;

public class ApproView {
    private static final Scanner scanner = new Scanner(System.in);

    private ApproView() {}

    public static int menuApprovisionnement() {
        MessagePrinter.printMessage("1. Diminuer la quantité");
        MessagePrinter.printMessage("2. Augmenter la quantité");
        MessagePrinter.printMessage("3. Supprimer l'article");
        MessagePrinter.printMessage("0. Quitter");

        return Integer.parseInt(scanner.nextLine());
    }

    public static void decreaseQuantityStockArticle(Article article) {
        int quantite;

        do {
            quantite = getQuantiteArticle();

            if(quantite <= article.getQuantiteStock()) {
                int quantiteFinal = article.getQuantiteStock() - quantite;
                article.setQuantiteStock(quantiteFinal);
            } else {
                MessagePrinter.printMessage("La quantité demandée est supérieure à la quantité en stock ! Reessayez.");
            }
        } while (quantite > article.getQuantiteStock());

    }

    public static void increaseQuantityStockArticle(Article article) {
        int quantite  = getQuantiteArticle();
        int quantiteFinal = article.getQuantiteStock() + quantite;
        article.setQuantiteStock(quantiteFinal);
    }

    public static int getQuantiteArticle() {
        MessagePrinter.printMessage("Saisissez la quantité de l'article :");
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

}
