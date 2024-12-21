package org.ism.menus;

import org.ism.core.config.Config;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.*;
import org.ism.entities.enums.StatutDette;
import org.ism.services.*;
import org.ism.views.ClientView;
import org.ism.views.DetailsDetteView;
import org.ism.views.DetteView;
import org.ism.views.PaymentView;


public abstract class DetteMenu {
    private static final IArticleService articleService = Config.getArticleService();
    private static final IClientService clientService = Config.getClientService();
    private static final IDetailsDetteArticleService detailsDetteArticleService = Config.getDetailsDetteArticleService();
    private static final IDetailsDettePaymentService detailsDettePaymentService = Config.getDetailsDettePaymentService();
    private static final IPaymentService paymentService = Config.getPaymentService();

    private DetteMenu(){}

    public static void start(IDetteService detteService) {
        int choix;

        do {
            choix = DetteView.menu();

            switch (choix) {
                case 1:
                    Dette nouvelleDette = DetteView.create(clientService.findAll(), articleService.findAll());
                    if(nouvelleDette != null) {
                        detteService.save(nouvelleDette);
                        // Mise à jour des details des articles d'une dette
                        for(DetailsDetteArticle detailsDetteArticle: nouvelleDette.getDetailsArticles()) {
                            detailsDetteArticleService.save(detailsDetteArticle);
                        }
                        // Mise à jour des details des paiements d'une dette
                        for(DetailsDettePayment detailsDettePayment: nouvelleDette.getDetailsPayments()) {
                            detailsDettePaymentService.save(detailsDettePayment);
                        }
                    }
                    break;
                case 2:
                    DetteView.show(detteService.findAll());
                    break;
                case 3:
                    DetteView.showByStatut(detteService.findAllByStatut(StatutDette.SOLDEE), StatutDette.SOLDEE.name());
                    break;
                case 4:
                    DetteView.showByStatut(detteService.findAllByStatut(StatutDette.NON_SOLDEE), StatutDette.SOLDEE.name());
                    break;
                case 5:
                    ClientView.show(clientService.findAll());
                    Client client = clientService.findById(ClientView.inputIdentifiant());
                    if (client != null) {
                        DetteView.showByClient(detteService.findAllByClient(client), client);
                    } else {
                        MessagePrinter.printMessage("Aucun client trouvé avec cet identifiant.");
                    }
                    break;
                case 6:
                    DetteView.show(detteService.findAll());
                    int detteId = DetteView.inputIdentifiant();
                    Dette dette = detteService.findById(detteId);
                    DetailsDetteView.infos(dette);
                    break;
                case 7:
                    int detteID = DetteView.inputIdentifiant();
                    Dette detteToPay = detteService.findById(detteID);
                    if (detteToPay != null) {
                        Payment payment = PaymentView.create(detteToPay);
                        paymentService.save(payment);
                        detteService.update(detteToPay);
                    }
                    break;
                case 0:
                    MessagePrinter.printMessage("Quitter...");
                    break;
                default:
                    MessagePrinter.printMessage("Choix invalide !");
            }
        } while (choix != 0);

    }
}
