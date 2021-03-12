package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Long> {

    Optional<CommandeClient> findCommandeClientByCode(String code);
}
