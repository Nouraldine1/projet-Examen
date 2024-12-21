package org.ism.repositories.impl;

import org.ism.entities.DetailsDemande;
import org.ism.repositories.IDetailsDemandeRepository;

import java.util.ArrayList;
import java.util.List;

public class DetailsDemandeRepositoryImpl implements IDetailsDemandeRepository {
    private final List<DetailsDemande> detailsDemandeList = new ArrayList<>();

    @Override
    public DetailsDemande save(DetailsDemande detailsDemande) {
        detailsDemandeList.add(detailsDemande);
        return detailsDemande;
    }

    @Override
    public List<DetailsDemande> findAll() {
        return new ArrayList<>(detailsDemandeList);
    }

    @Override
    public void update(DetailsDemande entity) {

    }

    @Override
    public void delete(DetailsDemande entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public DetailsDemande findById(int id) {
        for (DetailsDemande detailsDemande : detailsDemandeList) {
            if (detailsDemande.getId() == id) {
                return detailsDemande;
            }
        }
        return null;
    }

}
