package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.model.RoleEnum;
import cm.belrose.stockserveur.model.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleService {
    Optional<Role> findByName(RoleEnum name);

    void save(Role role);

    void saveAll(Set<Role> listOfRoles);

    List<Role> findAllRole();

}
