package cm.belrose.stockserveur.config;

import cm.belrose.stockserveur.model.ERole;
import cm.belrose.stockserveur.model.Role;
import cm.belrose.stockserveur.model.User;
import cm.belrose.stockserveur.repository.RoleRepository;
import cm.belrose.stockserveur.repository.UserRepository;
import cm.belrose.stockserveur.service.RoleService;
import cm.belrose.stockserveur.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;


/**
 * Le 16/11/2020 à 09heures
 *
 * @author Ngnawen Samuel
 *
 * Cette classe permet de créer le super utilisateur au demarrage de l'application avec ses roles
 */
@Component
public class InitializeDataBase implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializeDataBase.class);

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
            Optional<Role> role = roleRepository.findByName(ERole.ROLE_ADMIN);
            if (role.isEmpty()) {
                Set<Role> listOfRoles = new HashSet<>(Arrays.asList(new Role(ERole.ROLE_ADMIN), new Role(ERole.ROLE_MODERATOR), new Role(ERole.ROLE_USER)));
                listOfRoles.forEach(System.out::println);
                if(!CollectionUtils.isEmpty(listOfRoles)){
                    roleRepository.saveAll(listOfRoles);
                    logger.info("All roles successful save !!!!");
                }else{
                    logger.info("List of roles is empty !!!!");
                }
                User user = new User(Constant.DEFAULT_ADMIN_USERNAME, Constant.DEFAULT_ADMIN_EMAIL, passwordEncoder.encode(Constant.DEFAULT_ADMIN_PASSWORD),listOfRoles);
                userRepository.save(user);
                logger.info("Super user successful create!!!!");
            } else {
                logger.info("Super user is already exist!!!!");
            }

    }
}
