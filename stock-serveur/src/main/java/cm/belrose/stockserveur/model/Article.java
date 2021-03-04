package cm.belrose.stockserveur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Le 09/11/2020
 *
 *@author  Ngnawen Samuel
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Audited
@Entity
@Table(name = "articles")
public class Article extends AbstractAudingEntity<String> implements Serializable {
    @Column(name = "code_article")
    private String code;
    @Column(name = "designation_article")
    private String designation;
    @Column(name = "prix_unitaire_hors_taxe")
    private BigDecimal prixUnitaireHt;
    @Column(name = "taux_tva")
    private BigDecimal tauxTva;
    @Column(name = "prix_unitaire_ttc")
    private BigDecimal prixUnitaireTtc;
    @Column(name = "prix_achat")
    private BigDecimal prixAchat;
    @Column(name = "prix_vente")
    private BigDecimal prixVente;
    @Column(name = "quantite")
    private double quantite;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

}
