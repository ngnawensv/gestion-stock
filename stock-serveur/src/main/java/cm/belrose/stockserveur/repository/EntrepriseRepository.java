package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
    Optional<Entreprise> findEntrepriseByNom(String nom);
}
