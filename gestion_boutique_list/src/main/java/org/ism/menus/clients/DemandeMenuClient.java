package org.ism.menus.clients;


import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Client;
import org.ism.entities.Demande;
import org.ism.entities.enums.EtatDemande;
import org.ism.services.IArticleService;
import org.ism.services.IDemandeService;
import org.ism.views.DemandeView;

public class DemandeMenuClient {
    private DemandeMenuClient() {}

    public static void start(IDemandeService demandeService, IArticleService articleService, Client client) {
        int choix;

        do {
            choix = DemandeView.menuClient();

            switch (choix) {
                case 1:
                    Demande demande = DemandeView.create(articleService.findAll(), client);
                    if(demande != null) {
                        demandeService.save(demande);
                        MessagePrinter.printMessage("La demande a été enregistrée avec succès !");
                    } else {
                        MessagePrinter.printMessage("La demande n'a pas été enregistrée !");
                    }
                    break;
                case 2:
                    DemandeView.show(demandeService.findAllByClient(client));
                    break;
                case 3:
                    DemandeView.show(demandeService.findAllByClientAndEtat(client, EtatDemande.EN_COURS));
                    break;
                case 4:
                    DemandeView.show(demandeService.findAllByClientAndEtat(client, EtatDemande.REJETER));
                    break;
                case 5:
                    DemandeView.show(demandeService.findAllByClientAndEtat(client, EtatDemande.ACCEPTER));
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
