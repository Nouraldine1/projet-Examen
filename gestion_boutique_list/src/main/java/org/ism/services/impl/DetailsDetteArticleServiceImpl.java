package org.ism.services.impl;

import org.ism.entities.DetailsDetteArticle;
import org.ism.repositories.IDetailsDetteArticleRepository;
import org.ism.services.IDetailsDetteArticleService;

import java.util.List;

public class DetailsDetteArticleServiceImpl implements IDetailsDetteArticleService {
    private final IDetailsDetteArticleRepository detailsDetteArticleRepository;

    public DetailsDetteArticleServiceImpl(IDetailsDetteArticleRepository detailsDetteArticleRepository) {
        this.detailsDetteArticleRepository = detailsDetteArticleRepository;
    }

    @Override
    public DetailsDetteArticle save(DetailsDetteArticle detailsDetteArticle) {
        return detailsDetteArticleRepository.save(detailsDetteArticle);
    }

    @Override
    public List<DetailsDetteArticle> findAll() {
        return detailsDetteArticleRepository.findAll();
    }

    @Override
    public DetailsDetteArticle findById(int id) {
        return detailsDetteArticleRepository.findById(id);
    }

    @Override
    public void delete(DetailsDetteArticle detailsDetteArticle) {
        detailsDetteArticleRepository.delete(detailsDetteArticle);
    }

    @Override
    public void deleteById(int id) {
        detailsDetteArticleRepository.deleteById(id);
    }

    @Override
    public void update(DetailsDetteArticle entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
