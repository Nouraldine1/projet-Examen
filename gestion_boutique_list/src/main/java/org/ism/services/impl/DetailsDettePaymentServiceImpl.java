package org.ism.services.impl;

import org.ism.entities.DetailsDettePayment;
import org.ism.repositories.IDetailsDettePaymentRepository;
import org.ism.services.IDetailsDettePaymentService;

import java.util.List;

public class DetailsDettePaymentServiceImpl implements IDetailsDettePaymentService {
    private final IDetailsDettePaymentRepository detailsDettePaymentRepository;

    public DetailsDettePaymentServiceImpl(IDetailsDettePaymentRepository detailsDettePaymentRepository) {
        this.detailsDettePaymentRepository = detailsDettePaymentRepository;
    }

    @Override
    public DetailsDettePayment save(DetailsDettePayment detailsDettePayment) {
        return detailsDettePaymentRepository.save(detailsDettePayment);
    }

    @Override
    public List<DetailsDettePayment> findAll() {
        return detailsDettePaymentRepository.findAll();
    }

    @Override
    public DetailsDettePayment findById(int id) {
        return detailsDettePaymentRepository.findById(id);
    }

    @Override
    public void delete(DetailsDettePayment detailsDettePayment) {
        detailsDettePaymentRepository.delete(detailsDettePayment);
    }

    @Override
    public void deleteById(int id) {
        detailsDettePaymentRepository.deleteById(id);
    }

    @Override
    public void update(DetailsDettePayment entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
