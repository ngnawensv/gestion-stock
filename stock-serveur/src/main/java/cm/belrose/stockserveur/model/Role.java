package cm.belrose.stockserveur.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

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
@Audited
@Table(name = "roles")
public class Role extends AbstractAudingEntity<String> {
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum name;
    //Ce champs est juste mis pour simplifier les choses
    @Column(name = "entreprise_id")
    private Entreprise entreprise;
}

