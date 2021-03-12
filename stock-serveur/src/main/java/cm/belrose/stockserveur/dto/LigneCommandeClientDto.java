package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;

@Builder
@Data
public class LigneCommandeClientDto {
    private Long id;
    private ArticleDto articleDto;
    private CommandeClientDto commandeClientDto;
    private Entreprise entrepriseId;


    public static LigneCommandeClientDto fromEntity(LigneCommandeClient entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (Categorie==>CategorieDto)
        return LigneCommandeClientDto.builder()
                .id(entity.getId())
                .entrepriseId(entity.getEntrepriseId())
                .articleDto(ArticleDto.fromEntity(entity.getArticle()))
                .commandeClientDto(CommandeClientDto.fromEntity(entity.getCommandeClient()))
                .build();

    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Categorie (CategorieDto==>Categorie)
        LigneCommandeClient ligneCommandeClient=new LigneCommandeClient();
        ligneCommandeClient.setId(dto.getId());
        ligneCommandeClient.setEntrepriseId(dto.getEntrepriseId());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(dto.getArticleDto()));
        ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(dto.getCommandeClientDto()));
        return ligneCommandeClient;

    }
}
