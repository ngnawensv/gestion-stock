package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Adresse;
import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Builder
@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private Instant dateNaissance;
    private String genre;
    private String photo;
    private AdresseDto adresseDto;
    private EntrepriseDto entrepriseDto;
    @JsonIgnore
    private Set<RoleDto> rolesDto;


    public UserDto(String username, String email, String password, Set<RoleDto> rolesDto) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rolesDto = rolesDto;
    }

    public static UserDto fromEntity(User entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (Categorie==>CategorieDto)
        return UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .dateNaissance(entity.getDateNaissance())
                .genre(entity.getGenre())
                .photo(entity.getPhoto())
                .adresseDto(AdresseDto.fromEntity(entity.getAdresse()))
                .entrepriseDto(EntrepriseDto.fromEntity(entity.getEntreprise()))
                .build();

    }

    public static User toEntity(UserDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Categorie (CategorieDto==>Categorie)
        User user=new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setNom(dto.getNom());
        user.setPrenom(dto.getPrenom());
        user.setDateNaissance(dto.getDateNaissance());
        user.setGenre(dto.getGenre());
        user.setPhoto(dto.getPhoto());
        user.setEntreprise(EntrepriseDto.toEntity(dto.getEntrepriseDto()));
        return user;

    }
}
