package org.ism.views;


import org.ism.core.factory.ConcreteEntityFactory;
import org.ism.core.factory.EntityFactory;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Boutiquier;

import java.util.*;

public abstract class BoutiquierView {
    private static final Scanner scanner = new Scanner(System.in);

    private BoutiquierView() {}

    public static int menu() {
        MessagePrinter.printMessage("Faites votre choix : ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Boutiquier create() {
        MessagePrinter.printMessage("\n========= Enregistrer un boutiquier =========");

        MessagePrinter.printMessage("Noms : ");
        String noms = scanner.nextLine();

        MessagePrinter.printMessage("Prénoms : ");
        String prenoms = scanner.nextLine();

        MessagePrinter.printMessage("Téléphone : ");
        String telephone = scanner.nextLine();

        EntityFactory factory = new ConcreteEntityFactory();

        Map<String, Object> boutiquierParams = new HashMap<>();
        boutiquierParams.put("noms", noms);
        boutiquierParams.put("prenoms", prenoms);
        boutiquierParams.put("telephone", telephone);
        boutiquierParams.put("user", null);

        return (Boutiquier) factory.createEntity("Boutiquier", boutiquierParams);
    }

    public static void show(List<Boutiquier> boutiquiers) {
        MessagePrinter.printMessage("========= Liste des boutiquiers =========");
        if(boutiquiers.isEmpty()) {
            MessagePrinter.printMessage("Aucun boutiquier trouvé.");
        } else {
            for (Boutiquier boutiquier : boutiquiers) {
                MessagePrinter.printParameter(boutiquier);
            }
        }
    }

    public static int inputIdentifiant() {
        MessagePrinter.printMessage("Veuillez saisir l'identifiant du boutiquier : ");
        return Integer.parseInt(scanner.nextLine());
    }

}
