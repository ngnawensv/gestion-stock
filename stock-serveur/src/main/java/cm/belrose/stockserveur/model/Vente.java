package cm.belrose.stockserveur.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
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
@Table(name = "ventes")
public class Vente extends AbstractAudingEntity<String> implements Serializable {
    private String code;
    private Instant dateVente;
    private String commentaire;
    //Ce champs est juste mis pour simplifier les choses
    @Column(name = "entreprise_id")
    private Entreprise entrepriseId;
    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVenteList;
}
