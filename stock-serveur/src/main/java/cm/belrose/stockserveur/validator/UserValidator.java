package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ngnawen
 * @since 07/03/2021
 * Cette classe permet de valider une entité avant sa persistence dans une base de données.
 * La validation concerne principalement les champs obligatoires
 *
 */
public class UserValidator {

    public static List<String> validator(UserDto dto){
        List<String> errors=new ArrayList<>();
        if(dto==null){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("Veuillez renseigner l'email de l'utilisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }

        if(!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez renseigner l'email de l'utilisateur");
        }

        if(!StringUtils.hasLength(dto.getPassword())){
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
        }

        if(dto.getAdresseDto()==null){
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");
        }else{
            if(!StringUtils.hasLength(dto.getAdresseDto().getAdresse1())){
                errors.add("Le champs adresse 1 de l'utilisateur");
            }
            if(!StringUtils.hasLength(dto.getAdresseDto().getCodePostale())){
                errors.add("Le champs code postale de l'utilisateur");
            }
            if(!StringUtils.hasLength(dto.getAdresseDto().getVille())){
                errors.add("Le champs ville de l'utilisateur");
            }
            if(!StringUtils.hasLength(dto.getAdresseDto().getPays())){
                errors.add("Le champs pays de l'utilisateur");
            }

        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez rensigner le code de la catagorie");
        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez rensigner le code de la catagorie");
        }
        return errors;
    }
}
