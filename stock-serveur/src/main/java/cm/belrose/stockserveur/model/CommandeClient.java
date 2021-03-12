package cm.belrose.stockserveur.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 *
 * Le 09/11/2020
 *
 *@author  Ngnawen Samuel
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Commandeclients")
public class CommandeClient extends AbstractAudingEntity<String> implements Serializable {
      private String code;
      @Column(name = "date_commande")
      private Instant dateCommande;
      @ManyToOne
      @JoinColumn(name = "client_id")
      private Client client;
      @OneToMany(mappedBy = "commandeClient")
      private List<LigneCommandeClient> ligneCommandeClientList;
      //Ce champs est juste mis pour simplifier les choses
      @Column(name = "entreprise_id")
      private Entreprise entrepriseId;


}
