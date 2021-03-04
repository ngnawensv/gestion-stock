package cm.belrose.stockserveur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Le 09/11/2020
 *
 * @author Ngnawen Samuel
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "clients")
public class Client extends AbstractAudingEntity<String> implements Serializable {
    private String nom;
    private String prenom;
    private String genre;
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;
    @Column(name = "lieu_naissance")
    private String lieuNaissance;
    private String email;
    @Column(name = "num_tel")
    private String numTel;
    private String photo;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClientList;

}
