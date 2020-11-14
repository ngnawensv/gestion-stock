package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Ngnawen Samuel
 * <p>
 * at 07/11/2020
 */

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    Boolean existsByNom(String nom);

    void deleteById(Long id);

    void deleteAll();

   // returns all Categories which "nom" contains input "nom"
    List<Categorie> findByNomContaining(String nom);
    
    @Query("select cat from Categorie cat where cat.nom like :x")
    Page<Categorie> chercher(@Param("x") String keyword, Pageable pageable);
}
