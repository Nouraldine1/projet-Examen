package org.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ism.core.factory.IEntity;


import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DetailsDettePayment implements IEntity {
    private int id;
    private LocalDate date;
    private Payment payment;
    private Dette dette;

    private static int cpt;

    public DetailsDettePayment() {
        cpt++;
        this.id = cpt;
    }

    public DetailsDettePayment(LocalDate date, Payment payment, Dette dette) {
        cpt++;
        this.id = cpt;
        this.date = date;
        this.payment = payment;
        this.dette = dette;
    }

    @Override
    public String toString() {
        return "detailsPayment{" +
                "id=" + id +
                ", date=" + date +
                ", payment=" + payment +
                ", detteID=" + dette.getId() +
                '}';
    }
}
