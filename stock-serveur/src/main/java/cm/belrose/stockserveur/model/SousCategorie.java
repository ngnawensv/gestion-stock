package cm.belrose.stockserveur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "souscategories")
public class SousCategorie extends AbstractAudingEntity<String> implements Serializable {

    @Column(name = "code_sous_categorie")
    private String code;

    @Column(name = "nom_sous_categorie")
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
