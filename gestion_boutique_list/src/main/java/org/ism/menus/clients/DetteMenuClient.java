package org.ism.menus.clients;

import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Client;
import org.ism.entities.Dette;
import org.ism.entities.enums.StatutDette;
import org.ism.services.*;
import org.ism.views.DetailsDetteView;
import org.ism.views.DetteView;


public abstract class DetteMenuClient {

    private DetteMenuClient(){}

    public static void start(IDetteService detteService, Client client) {
        int choix;

        do {
            choix = DetteView.menuDettesClient();

            switch (choix) {
                case 1:
                    DetteView.show(detteService.findAllByClient(client));
                    break;
                case 2:
                    DetteView.show(detteService.findAllByClientAndStatut(client, StatutDette.SOLDEE));
                    break;
                case 3:
                    DetteView.show(detteService.findAllByClientAndStatut(client, StatutDette.NON_SOLDEE));
                    break;
                case 4:
                    DetteView.show(detteService.findAllByClient(client));
                    int detteID = DetteView.inputIdentifiant();
                    Dette detteTrouve = detteService.findById(detteID);
                    if (detteTrouve != null) {
                        MessagePrinter.printMessage("Détails de la dette : " + detteTrouve.getId());

                        int menuDetails;

                        do {
                            menuDetails = DetailsDetteView.showSubmenu();
                            switch (menuDetails) {
                                case 1:
                                    MessagePrinter.printMessage("Articles de la dette");
                                    DetailsDetteView.showArticle(detteTrouve.getDetailsArticles());
                                    break;
                                case 2:
                                    MessagePrinter.printMessage("Paiements de la dette");
                                    DetailsDetteView.showPayment(detteTrouve.getDetailsPayments());
                                    break;
                                default: MessagePrinter.printMessage("Choix invalide !");
                            }
                        } while(menuDetails != 0);

                    } else {
                        MessagePrinter.printMessage("Aucune dette trouvée avec cet identifiant.");
                    }
                    break;
                case 0:
                    MessagePrinter.printMessage("Quitter...");
                    break;
                default:
                    MessagePrinter.printMessage("Choix invalide");
            }
        } while (choix != 0);

    }
}
