package org.ism.menus;

import org.ism.core.config.Config;
import org.ism.entities.Article;
import org.ism.services.IArticleService;
import org.ism.views.ApproView;
import org.ism.views.ArticleView;

public abstract class ApproMenu {
    private static final IArticleService articleService = Config.getArticleService();
    private ApproMenu() {}

    public static void start() {
        int choice = ApproView.menuApprovisionnement();

        switch (choice) {
            case 1:
                // Diminution de la quantite de l'article
                String libelle = ArticleView.inputLibelle();
                Article article = articleService.findByLibelle(libelle);
                if(article != null) {
                    ApproView.decreaseQuantityStockArticle(article);
                    articleService.updateEtat(article);
                    articleService.update(article);
                } else {
                    System.out.println("\"" + libelle + "\" n'existe pas en stock");
                }
                break;
            case 2:
                // Augmentation de la quantite de l'article
                String libelle2 = ArticleView.inputLibelle();
                Article article2 = articleService.findByLibelle(libelle2);

                if(article2 != null) {
                    ApproView.increaseQuantityStockArticle(article2);
                    articleService.updateEtat(article2);
                    articleService.update(article2);
                } else {
                    System.out.println("\"" + libelle2 + "\" n'existe pas en stock");
                }
                break;
            case 3:
                // Suppression de l'article du stock
                String libelle3 = ArticleView.inputLibelle();
                Article article3 = articleService.findByLibelle(libelle3);

                if(article3 != null) {
                    articleService.delete(article3);
                    System.out.println("\"" + libelle3 + "\" a été supprimé du stock");
                } else {
                    System.out.println("\"" + libelle3 + "\" n'existe pas en stock");
                }
                break;
            default:
                // Retour au menu précédent
                System.out.println("Retour au menu précédent...");
                break;
        }

    }
}
