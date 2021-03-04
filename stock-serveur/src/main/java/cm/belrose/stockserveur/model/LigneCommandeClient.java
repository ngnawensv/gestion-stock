package cm.belrose.stockserveur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Le 09/11/2020
 *
 *@author  Ngnawen Samuel
 *
 */
@Data
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

}
