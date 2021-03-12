package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
