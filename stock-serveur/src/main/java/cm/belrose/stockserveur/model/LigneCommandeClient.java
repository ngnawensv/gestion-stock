package cm.belrose.stockserveur.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
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
@Table(name = "lignecommandeclients")
public class LigneCommandeClient extends AbstractAudingEntity<String> implements Serializable {

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "commandeclient_id")
    private CommandeClient commandeClient;
    //Ce champs est juste mis pour simplifier les choses
    @Column(name = "entreprise_id")
    private Entreprise entrepriseId;

}
