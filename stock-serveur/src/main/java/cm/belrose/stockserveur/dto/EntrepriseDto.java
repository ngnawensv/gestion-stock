package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EntrepriseDto {
    private Long id;
    private String nom;
    private String logo;


    public static EntrepriseDto fromEntity(Entreprise entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type EntrepriseDto (Entreprise==>EntrepriseDto)
        return EntrepriseDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .logo(entity.getLogo())
                .build();

    }

    public static Entreprise toEntity(EntrepriseDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Entreprise (EntrepriseDto==>Entreprise)
        Entreprise entreprise=new Entreprise();
        entreprise.setId(dto.getId());
        entreprise.setNom(dto.getNom());
        entreprise.setLogo(dto.getLogo());
        return entreprise;

    }
}
