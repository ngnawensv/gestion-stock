package cm.belrose.stockserveur.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entreprises")
public class Entreprise extends AbstractAudingEntity<String> implements Serializable {
    private String nom;
    private String logo;
}
