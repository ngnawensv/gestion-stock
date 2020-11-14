package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.model.ERole;
import cm.belrose.stockserveur.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(ERole name);
}
