package cm.belrose.stockserveur.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 *@author  Ngnawen Samuel
 * @since  09/11/2020 20:30:00
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Audited
@Entity
@Table(name = "categories")
public class Categorie extends AbstractAudingEntity<String> implements Serializable {
    private String code;
    private String libelle;
    @OneToMany(mappedBy = "categorie")
    private List<Article> articleList;
}
