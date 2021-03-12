package cm.belrose.stockserveur.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        }
        )
public class User extends AbstractAudingEntity<String> implements Serializable {

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    private String nom;
    private String prenom;
    @Column(name = "date_naissance")
    private Instant dateNaissance;
    private String genre;
    private String photo;
    @Embedded
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name = "entrprise_id")
    private Entreprise entreprise;

    /**
     * FetchType.LAZY : indique que la relation doit être chargée à la demande ;
     * FetchType.EAGER : indique que la relation (User-role) doit être chargée en même temps que l'entité qui la User
     */
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
