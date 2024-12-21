package org.ism.services.impl;

import org.ism.entities.Payment;
import org.ism.repositories.IPaymentRepository;
import org.ism.services.IPaymentService;

import java.util.List;


public class PaymentServiceImpl implements IPaymentService {
    private final IPaymentRepository paymentRepository;

    public PaymentServiceImpl(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(int id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void update(Payment payment) {
        paymentRepository.update(payment);
    }

    @Override
    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }

    @Override
    public void deleteById(int id) {
        paymentRepository.deleteById(id);
    }
}
