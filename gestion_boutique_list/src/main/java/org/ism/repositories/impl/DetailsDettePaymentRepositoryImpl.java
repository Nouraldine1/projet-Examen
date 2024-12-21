package org.ism.repositories.impl;

import org.ism.entities.DetailsDettePayment;
import org.ism.repositories.IDetailsDettePaymentRepository;

import java.util.ArrayList;
import java.util.List;

public class DetailsDettePaymentRepositoryImpl implements IDetailsDettePaymentRepository {
    private final List<DetailsDettePayment> detailsDettePaymentList = new ArrayList<>();

    @Override
    public DetailsDettePayment save(DetailsDettePayment detailsDettePayment) {
        detailsDettePaymentList.add(detailsDettePayment);
        return detailsDettePayment;
    }

    @Override
    public List<DetailsDettePayment> findAll() {
        return new ArrayList<>(detailsDettePaymentList);
    }

    @Override
    public void update(DetailsDettePayment entity) {

    }

    @Override
    public void delete(DetailsDettePayment entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public DetailsDettePayment findById(int id) {
        for (DetailsDettePayment detailsDettePayment : detailsDettePaymentList) {
            if (detailsDettePayment.getId() == id) {
                return detailsDettePayment;
            }
        }
        return null;
    }
}
