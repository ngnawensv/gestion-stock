package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.Categorie;
import cm.belrose.stockserveur.model.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SousCategorieRepository extends JpaRepository<SousCategorie,Long> {
    Optional<SousCategorie> findSousCategorieByCode(String code);
}
