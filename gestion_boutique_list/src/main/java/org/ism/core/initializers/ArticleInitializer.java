package org.ism.core.initializers;

import org.ism.entities.Article;
import org.ism.entities.enums.EtatArticle;
import org.ism.services.IArticleService;

import java.util.List;

public class ArticleInitializer {
    private final IArticleService articleService;

    public ArticleInitializer(IArticleService articleService) {
        this.articleService = articleService;
    }

    public void initializeDefaultArticles() {
        List<Article> articles = create();
        for(Article article: articles) {
            if(articleService.findByLibelle(article.getLibelle()) == null) {
                articleService.save(article);
            } else {
                System.out.println("\"" + article.getLibelle() + " existe déjà en stock");
            }
        }
    }

    public List<Article> create() {
        return List.of(
            new Article("Cerelac", 350.0, 50, EtatArticle.DISPONIBLE),
            new Article("Lait Nido", 125.0, 100, EtatArticle.DISPONIBLE),
            new Article("Quaker", 750.0, 70, EtatArticle.DISPONIBLE),
            new Article("Nesquik", 1350.0, 40, EtatArticle.DISPONIBLE),
            new Article("Sucre", 175.0, 100, EtatArticle.DISPONIBLE),
            new Article("Miel", 1500.0, 70, EtatArticle.DISPONIBLE),
            new Article("Beurre", 2500.0, 10, EtatArticle.DISPONIBLE),
            new Article("Margarine", 1000.0, 5, EtatArticle.DISPONIBLE),
            new Article("Fromage Blanc", 3500.0, 7, EtatArticle.DISPONIBLE),
            new Article("Emmental Râpés", 5099.0, 70, EtatArticle.DISPONIBLE)
        );
    }

}
