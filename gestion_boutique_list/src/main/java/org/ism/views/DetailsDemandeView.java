package org.ism.views;

import org.ism.core.factory.ConcreteEntityFactory;
import org.ism.core.factory.EntityFactory;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Article;
import org.ism.entities.Demande;
import org.ism.entities.DetailsDemande;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class DetailsDemandeView {
    private static final Scanner scanner = new Scanner(System.in);

    private DetailsDemandeView(){}

    public static DetailsDemande create(int quantite, Article article, Demande demande) {
        EntityFactory factory = new ConcreteEntityFactory();

        Map<String, Object> detailsParams = new HashMap<>();
        detailsParams.put("quantite", quantite);
        detailsParams.put("article", article);
        detailsParams.put("demande", demande);

        return (DetailsDemande) factory.createEntity("DetailsDemande", detailsParams);
    }

    public static void show(List<DetailsDemande> detailsDemandes) {
        MessagePrinter.printMessage("===== Détails de la demande =====");
        if(detailsDemandes.isEmpty()) {
            MessagePrinter.printMessage("Aucun détail demande trouvé.");
        } else {
            for (DetailsDemande detailsDemande: detailsDemandes) {
                MessagePrinter.printParameter(detailsDemande);
            }
        }
    }

    public static DetailsDemande search(List<DetailsDemande> details) {
        int id = inputIdentifiant();
        for(DetailsDemande detailsDemande: details) {
            if(detailsDemande.getId() == id) {
                return detailsDemande;
            }
        }
        return null;
    }

    public static int inputIdentifiant() {
        MessagePrinter.printMessage("Veuillez saisir l'Identifiant du détails la demande : ");
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


}
