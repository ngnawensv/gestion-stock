package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Adresse;
import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class FournisseurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String genre;
    private Instant dateNaissance;
    private String lieuNaissance;
    private String email;
    private String numTel;
    private String photo;
    private AdresseDto adresseDto;
    private Entreprise entrepriseId;
    @JsonIgnore
    private List<CommandeFournisseurDto> commandeFournisseurListDto;


    public static FournisseurDto fromEntity(Fournisseur entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (Categorie==>CategorieDto)
        return FournisseurDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .genre(entity.getGenre())
                .dateNaissance(entity.getDateNaissance())
                .lieuNaissance(entity.getLieuNaissance())
                .email(entity.getEmail())
                .numTel(entity.getNumTel())
                .photo(entity.getPhoto())
                .entrepriseId(entity.getEntrepriseId())
                .adresseDto(AdresseDto.fromEntity(entity.getAdresse()))
                .build();

    }

    public static Fournisseur toEntity(FournisseurDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Categorie (CategorieDto==>Categorie)
        Fournisseur fournisseur=new Fournisseur();
        fournisseur.setId(dto.getId());
        fournisseur.setNom(dto.getNom());
        fournisseur.setPrenom(dto.getPrenom());
        fournisseur.setGenre(dto.getGenre());
        fournisseur.setDateNaissance(dto.getDateNaissance());
        fournisseur.setLieuNaissance(dto.getLieuNaissance());
        fournisseur.setEmail(dto.getEmail());
        fournisseur.setNumTel(dto.getNumTel());
        fournisseur.setPhoto(dto.getPhoto());
        fournisseur.setEntrepriseId(dto.getEntrepriseId());
        fournisseur.setAdresse(AdresseDto.toEntity(dto.getAdresseDto()));
        return fournisseur;

    }
}
