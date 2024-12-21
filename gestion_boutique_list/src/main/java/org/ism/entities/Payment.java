package org.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ism.core.factory.IEntity;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Payment implements IEntity {
    private int id;
    private LocalDate date;
    private double montant;
    private Dette dette;

    private static int cpt;

    public Payment() {
        cpt++;
        this.id = cpt;
    }

    public Payment(final LocalDate date, final double montant, final Dette dette) {
        cpt++;
        this.id = cpt;
        this.date = date;
        this.montant = montant;
        this.dette = dette;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", montant=" + montant +
                ", detteID=" + dette.getId() +
                "}";
    }
    
}
