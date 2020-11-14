package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.repository.ArticleRepository;
import cm.belrose.stockserveur.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Le 11/11/2020
 * @author Ngnawen Samuel
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;


    @Override
    public Optional<Article> findById(Long id) throws Exception {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> findAll() throws Exception {
        return articleRepository.findAll();
    }

    @Override
    public Article save(Article article) throws Exception {
        return articleRepository.save(article);
    }

    @Override
    public Article update(Article article) throws Exception {
        return articleRepository.save(article);
    }

    @Override
    public void delete(Article article) throws Exception {
        articleRepository.delete(article);
    }
}
