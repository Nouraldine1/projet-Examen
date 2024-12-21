package org.ism.repositories.impl;

import org.ism.entities.Payment;
import org.ism.repositories.IPaymentRepository;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepositoryImpl implements IPaymentRepository {
    private final List<Payment> payments = new ArrayList<>();

    @Override
    public Payment save(Payment payment) {
        payments.add(payment);
        return payment;
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(payments);
    }

    @Override
    public Payment findById(int id) {
        for (Payment payment : payments) {
            if (payment.getId() == id) {
                return payment;
            }
        }
        return null;
    }

    @Override
    public void delete(Payment payment) {
        payments.remove(payment);
    }

    @Override
    public void deleteById(int id) {
        payments.removeIf(p -> p.getId() == id);
    }

    @Override
    public void update(Payment payment) {
        int index = payments.indexOf(payment);
        if (index!= -1) {
            payments.set(index, payment);
        }
    }
}
