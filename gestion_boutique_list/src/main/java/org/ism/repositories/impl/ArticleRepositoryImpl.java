package org.ism.repositories.impl;

import org.ism.entities.Article;
import org.ism.entities.enums.EtatArticle;
import org.ism.repositories.IArticleRepository;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImpl implements IArticleRepository {
    private final List<Article> articles = new ArrayList<>();

    @Override
    public List<Article> findAll() {
        return new ArrayList<>(articles);
    }

    @Override
    public Article save(Article article) {
        articles.add(article);
        return article;
    }

    @Override
    public Article findById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    @Override
    public void update(Article article) {
        int index = articles.indexOf(article);
        if (index!= -1) {
            articles.set(index, article);
        }
    }

    @Override
    public void delete(Article article) {
        articles.remove(article);
    }

    @Override
    public void deleteById(int id) {
        articles.removeIf(a -> a.getId() == id);
    }

    @Override
    public Article findByLibelle(String libelle) {
        for (Article article : articles) {
            if (article.getLibelle().equals(libelle)) {
                return article;
            }
        }
        return null;
    }

    @Override
    public void updateEtat(Article article) {
        if(article.getQuantiteStock() == 0) {
            article.setEtat(EtatArticle.RUPTURE);
        }
    }
}
