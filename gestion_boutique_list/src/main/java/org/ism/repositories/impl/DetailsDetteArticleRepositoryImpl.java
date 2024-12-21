package org.ism.repositories.impl;

import org.ism.entities.DetailsDetteArticle;
import org.ism.repositories.IDetailsDetteArticleRepository;

import java.util.ArrayList;
import java.util.List;

public class DetailsDetteArticleRepositoryImpl implements IDetailsDetteArticleRepository {
    private final List<DetailsDetteArticle> detailsDetteArticleList = new ArrayList<>();

    @Override
    public DetailsDetteArticle save(DetailsDetteArticle detailsDetteArticle) {
        detailsDetteArticleList.add(detailsDetteArticle);
        return detailsDetteArticle;
    }

    @Override
    public List<DetailsDetteArticle> findAll() {
        return new ArrayList<>(detailsDetteArticleList);
    }

    @Override
    public void update(DetailsDetteArticle entity) {

    }

    @Override
    public void delete(DetailsDetteArticle entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public DetailsDetteArticle findById(int id) {
        for (DetailsDetteArticle detailsDetteArticle : detailsDetteArticleList) {
            if (detailsDetteArticle.getId() == id) {
                return detailsDetteArticle;
            }
        }
        return null;
    }
}
