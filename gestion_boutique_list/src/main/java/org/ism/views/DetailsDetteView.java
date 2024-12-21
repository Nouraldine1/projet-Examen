package org.ism.views;

import org.ism.core.utils.MessagePrinter;
import org.ism.entities.DetailsDetteArticle;
import org.ism.entities.DetailsDettePayment;
import org.ism.entities.Dette;

import java.util.List;
import java.util.Scanner;

public abstract class DetailsDetteView {

    private DetailsDetteView() {}

    private static final Scanner scanner = new Scanner(System.in);

    public static void showArticle(List<DetailsDetteArticle> detailsArticles) {
        if(!detailsArticles.isEmpty()) {
            for(DetailsDetteArticle detail : detailsArticles) {
                MessagePrinter.printParameter(detail);
            }
        } else {
            MessagePrinter.printMessage("Aucun détail de dette pour cet article.");
        }

    }

    public static void showPayment(List<DetailsDettePayment> detailsPayments) {
        if(!detailsPayments.isEmpty()) {
            for(DetailsDettePayment detail : detailsPayments) {
                MessagePrinter.printParameter(detail);
            }
        } else {
            MessagePrinter.printMessage("Aucun détail de dette pour cette paiement.");
        }
    }

    public static int showSubmenu() {
        MessagePrinter.printMessage("======= Menu détails de la dette ======");
        MessagePrinter.printMessage("1. Articles");
        MessagePrinter.printMessage("2. Paiements");
        MessagePrinter.printMessage("0. Précédent");
        MessagePrinter.printMessage("Faites votre choix : ");

        return Integer.parseInt(scanner.nextLine());
    }

    public static void infos(Dette dette) {
        if (dette != null) {

            int choiceMenuDetailsDette;
            do {
                choiceMenuDetailsDette = showSubmenu();
                switch (choiceMenuDetailsDette) {
                    case 1:
                        MessagePrinter.printMessage("Articles de la dette");
                        showArticle(dette.getDetailsArticles());
                        break;
                    case 2:
                        MessagePrinter.printMessage("Paiements de la dette");
                        showPayment(dette.getDetailsPayments());
                        break;
                    case 0:
                        MessagePrinter.printMessage("Précédent...");
                        break;
                    default:
                        MessagePrinter.printMessage("Choix invalide");
                }

            } while (choiceMenuDetailsDette != 0);
        } else {
            MessagePrinter.printMessage("Aucune dette trouvée avec cet identifiant.");
        }
    }
}
