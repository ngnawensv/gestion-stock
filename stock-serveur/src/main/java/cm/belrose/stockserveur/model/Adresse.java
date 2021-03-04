package cm.belrose.stockserveur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Adresse {
    @Column(name = "adresse_1")
    private String adresse1;
    @Column(name = "adresse_Z")
    private String adresse2;
    private String ville;
    @Column(name = "code_postale")
    private String codePostale;
    private String pays;

}
