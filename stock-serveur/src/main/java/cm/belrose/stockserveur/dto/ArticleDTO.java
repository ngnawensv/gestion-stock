package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Categorie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ArticleDTO {
    private String code;
    private String designation;
    private BigDecimal prixUnitaireHt;
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private BigDecimal prixAchat;
    private BigDecimal prixVente;
    private double quantite;
    private Categorie categorie;
}
