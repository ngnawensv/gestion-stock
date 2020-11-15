package cm.belrose.stockserveur.config;

import cm.belrose.stockserveur.Security.services.UserDetailsImpl;
import cm.belrose.stockserveur.model.User;
import cm.belrose.stockserveur.service.impl.UserServiceImpl;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Le 14/11/2020
 *
 * @author Ngnawen Samuel
 */

public class AuditorAwareImpl implements AuditorAware<String> {

    public AuditorAwareImpl() {
    }

    /*@Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Admin");
    }*/

    @Override
    @Transactional
    public Optional<String> getCurrentAuditor() {
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }*/
        String username=UserServiceImpl.getCurrentUser();
        System.out.println("User in spring context====>"+username);
        return Optional.of(username);
    }
}
