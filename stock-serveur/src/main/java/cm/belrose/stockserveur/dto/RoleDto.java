package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.RoleEnum;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDto {
    private Long id;
    private RoleEnum name;
}
