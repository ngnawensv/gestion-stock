package cm.belrose.stockserveur.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 *
 *Le 09/11/2020
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
@Table(name = "Commandefournisseur")
public class CommandeFournisseur extends AbstractAudingEntity<String> implements Serializable {
    private String code;
    @Column(name = "date_commande")
    private Instant dateCommande;
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurList;
    //Ce champs est juste mis pour simplifier les choses
    @Column(name = "entreprise_id")
    private Entreprise entrepriseId;
}
