package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Long> {
}
