package org.ism.services.impl;

import org.ism.entities.DetailsDemande;
import org.ism.repositories.IDetailsDemandeRepository;
import org.ism.services.IDetailsDemandeService;

import java.util.List;

public class DetailsDemandeServiceImpl implements IDetailsDemandeService {
    private final IDetailsDemandeRepository detailsDemandeRepository;

    public DetailsDemandeServiceImpl(IDetailsDemandeRepository detailsDemandeRepository) {
        this.detailsDemandeRepository = detailsDemandeRepository;
    }

    @Override
    public DetailsDemande save(DetailsDemande details) {
        return detailsDemandeRepository.save(details);
    }

    @Override
    public List<DetailsDemande> findAll() {
        return detailsDemandeRepository.findAll();
    }

    @Override
    public DetailsDemande findById(int id) {
        return detailsDemandeRepository.findById(id);
    }

    @Override
    public void delete(DetailsDemande detailsDemande) {
        detailsDemandeRepository.delete(detailsDemande);
    }

    @Override
    public void deleteById(int id) {
        detailsDemandeRepository.deleteById(id);
    }

    @Override
    public void update(DetailsDemande entity) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
