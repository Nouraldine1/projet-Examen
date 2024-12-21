package org.ism.views;

import org.ism.core.factory.ConcreteEntityFactory;
import org.ism.core.factory.EntityFactory;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.DetailsDettePayment;
import org.ism.entities.Dette;
import org.ism.entities.Payment;
import org.ism.entities.enums.StatutDette;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class PaymentView {
    private PaymentView(){}

    private static final Scanner scanner = new Scanner(System.in);

    public static Payment create(Dette dette) {

        if(dette.getMontantVerser() < dette.getMontantTotal()) {
            String response = popupConfirm();

            if (response.equalsIgnoreCase("oui")) {
                EntityFactory factory = new ConcreteEntityFactory();

                LocalDate date = LocalDate.now();
                double montantRestant = dette.getMontantTotal() - dette.getMontantVerser();
                double montantVerser = inputMontant(dette.getMontantTotal(), montantRestant);

                // Ajout du montant versé de la dette
                dette.setMontantVerser(dette.getMontantVerser() + montantVerser);

                // Construction du paiement
                Map<String, Object> paymentParams = new HashMap<>();
                paymentParams.put("date", date);
                paymentParams.put("montant", montantVerser);
                paymentParams.put("dette", dette);

                Payment payment = (Payment) factory.createEntity("Payment", paymentParams);

                // Construction des détails de paiements
                Map<String, Object> detailsPaymentParams = new HashMap<>();
                detailsPaymentParams.put("date", date);
                detailsPaymentParams.put("payment", payment);
                detailsPaymentParams.put("dette", dette);

                DetailsDettePayment detailsPayment = (DetailsDettePayment) factory.createEntity("DetailsDettePayment", detailsPaymentParams);

                // Ajout du detailsPayment dans la dette
                dette.getDetailsPayments().add(detailsPayment);

                // Calcul du montant restant à verser (figuré)
                montantRestant = generateMontantRestant(montantRestant, dette.getDetailsPayments());

                // Met à jour le statut de la dette à SOLDEE
                if(montantRestant == dette.getMontantTotal()) {
                    dette.setStatut(StatutDette.SOLDEE);
                }

                MessagePrinter.printMessage("Paiement enregistré avec succès.");
                return payment;

            } else {
                MessagePrinter.printMessage("Paiement non enregistré.");
                return null;
            }

        } else {
            MessagePrinter.printMessage("Cette dette est soldée ! Impossible de l'ajouter un nouveau paiement.");
            return null;
        }
    }

    public static void showPayments(List<Payment> payments) {
        MessagePrinter.printMessage("===== Liste des paiements =====");

        if(!payments.isEmpty()) {
            for(Payment payment : payments) {
                MessagePrinter.printParameter(payment);
            }
        } else {
            MessagePrinter.printMessage("Aucun paiement pour cette dette.");
        }
    }

    public static double inputMontant(double montantTotal, double montantRestant) {
        MessagePrinter.printMessage("Saisissez le montant du paiement : ");
        double montant;

        // Validation de l'entrée du montant verser
        while (true) {
            try {
                montant = Double.parseDouble(scanner.nextLine());
                if (montant >= montantTotal) {
                    MessagePrinter.printMessage("Le montant du versement doit être inférieur ou égale au montant total de la dette. Réessayez :");
                    continue;
                } else if (montant > (montantTotal - montantRestant)) {
                    MessagePrinter.printMessage("Le montant du versement doit être inférieur au montant restant. Réessayez :");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                MessagePrinter.printMessage("Entrée invalide. Veuillez entrer un nombre valide.");
            }
        }

        return montant;
    }

    public static String popupConfirm() {
        MessagePrinter.printMessage("Voulez-vous enregistrer un paiement pour cette dette ? (Oui/Non");
        String response;

        while(true) {
            try {
                response = scanner.nextLine();
                if(!response.equalsIgnoreCase("oui") && !response.equalsIgnoreCase("non")) {
                    MessagePrinter.printMessage("Veuillez entrer Oui ou Non.");
                    continue;
                }
                break;
            } catch (Exception e) {
                MessagePrinter.printMessage("Entrée invalide. Veuillez entrer une réponse valide.");
            }
        }

        return response;
    }

    public static double generateMontantRestant (double montantRestant, List<DetailsDettePayment> detailsPayments) {
        for (DetailsDettePayment details: detailsPayments) {
            montantRestant += details.getPayment().getMontant();
        }

        return montantRestant;
    }
}
