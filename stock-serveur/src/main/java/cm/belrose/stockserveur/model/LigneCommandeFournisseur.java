package cm.belrose.stockserveur.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignecommandefournisseurs")
public class LigneCommandeFournisseur extends AbstractAudingEntity<String> implements Serializable {
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "commandefournisseur_id")
    private CommandeFournisseur commandeFournisseur;
    //Ce champs est juste mis pour simplifier les choses
    @Column(name = "entreprise_id")
    private Entreprise entrepriseId;
}
