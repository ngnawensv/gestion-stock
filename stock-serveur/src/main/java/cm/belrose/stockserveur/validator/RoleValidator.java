package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.RoleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {
    public static List<String> validator(RoleDto dto){
        List<String> errors=new ArrayList<>();
        if(dto==null||!StringUtils.hasLength(dto.getName().name())){
            errors.add("Veuillez renseigner le nom du role");
        }
        return errors;
    }
}
