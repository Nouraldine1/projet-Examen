package org.ism.services.impl;

import org.ism.entities.Article;
import org.ism.entities.enums.EtatArticle;
import org.ism.repositories.IArticleRepository;
import org.ism.services.IArticleService;

import java.util.List;

public class ArticleServiceImpl implements IArticleService {
    private final IArticleRepository articleRepository;

    public ArticleServiceImpl(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }

    public Article findByLibelle(String libelle) {
        return articleRepository.findByLibelle(libelle);
    }

    @Override
    public void update(Article article) {
        articleRepository.update(article);
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Article> findByEtat(EtatArticle etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEtat'");
    }

    @Override
    public void updateEtat(Article article) {
        articleRepository.updateEtat(article);
    }
}
