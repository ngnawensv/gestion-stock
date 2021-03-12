package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.CommandeClient;
import cm.belrose.stockserveur.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepository  extends JpaRepository<CommandeFournisseur,Long> {

    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
