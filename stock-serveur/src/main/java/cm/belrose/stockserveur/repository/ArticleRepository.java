package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 *@author  Ngnawen Samuel
 */

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long>{

    List<Article> findByDesignationContaining(String designation);

    Optional<Article> findArticleByCode(String code);
}
