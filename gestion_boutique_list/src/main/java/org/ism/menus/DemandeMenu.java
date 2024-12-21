package org.ism.menus;

import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Demande;
import org.ism.entities.enums.EtatDemande;
import org.ism.services.IDemandeService;
import org.ism.views.DemandeView;

public abstract class DemandeMenu {
    private DemandeMenu() {}

    public static void start(IDemandeService demandeService) {
        int choix;

        do {
            choix = DemandeView.menu();

            switch (choix) {
                case 1:
                    DemandeView.show(demandeService.findAll());
                    break;
                case 2:
                    DemandeView.show(demandeService.findAllByEtat(EtatDemande.EN_COURS));
                    break;
                case 3:
                    DemandeView.show(demandeService.findAllByEtat(EtatDemande.REJETER));
                    break;
                case 4:
                    DemandeView.show(demandeService.findAllByEtat(EtatDemande.ACCEPTER));
                    break;
                case 5:
                    Demande demande = DemandeView.search(demandeService.findAll());
                    if(demande!= null) {
                        MessagePrinter.printMessage("Traitement de la demande...");

                        int choice;
                        do {
                            choice = DemandeView.subMenuProcess();
                            switch (choice) {
                                case 1:
                                    demandeService.processRequest(demande, EtatDemande.REJETER);
                                    break;
                                case 2:
                                    demandeService.processRequest(demande, EtatDemande.ACCEPTER);
                                    break;
                                case 0:
                                    MessagePrinter.printMessage("Retour au menu principal.");
                                    break;
                                default:
                                    MessagePrinter.printMessage("Choix invalide");
                            }
                        } while (choice != 1 && choice != 2);

                    } else {
                        MessagePrinter.printMessage("Aucune demande trouvée avec cet identifiant.");
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
