package cm.belrose.stockserveur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fournisseur")
public class Fournisseur extends AbstractAudingEntity<String> implements Serializable {
    private String nom;
    private String prenom;
    private String genre;
    @Column(name = "date_naissance")
    private Instant dateNaissance;
    @Column(name = "lieu_naissance")
    private String lieuNaissance;
    private String email;
    @Column(name = "num_tel")
    private String numTel;
    private String photo;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurList;
    //Ce champs est juste mis pour simplifier les choses
    @Column(name = "entreprise_id")
    private Entreprise entrepriseId;
}
