package cm.belrose.stockserveur.model;

import lombok.*;

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
@Builder
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
    //Ce champs est juste mis pour simplifier les choses
    @Column(name = "entreprise_id")
    private Entreprise entrepriseId;

}