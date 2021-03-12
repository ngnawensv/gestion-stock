package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementStockRepository extends JpaRepository<MouvementStock,Long> {
}
