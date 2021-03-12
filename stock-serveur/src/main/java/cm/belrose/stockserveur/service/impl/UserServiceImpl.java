package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.Security.jwt.JwtUtils;
import cm.belrose.stockserveur.Security.services.UserDetailsImpl;
import cm.belrose.stockserveur.dto.ClientDto;
import cm.belrose.stockserveur.dto.UserDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.RoleEnum;
import cm.belrose.stockserveur.model.Role;
import cm.belrose.stockserveur.model.User;
import cm.belrose.stockserveur.payload.request.LoginRequest;
import cm.belrose.stockserveur.payload.request.SignupRequest;
import cm.belrose.stockserveur.payload.response.JwtResponse;
import cm.belrose.stockserveur.payload.response.MessageResponse;
import cm.belrose.stockserveur.repository.RoleRepository;
import cm.belrose.stockserveur.repository.UserRepository;
import cm.belrose.stockserveur.service.UserService;
import cm.belrose.stockserveur.validator.ClientValidator;
import cm.belrose.stockserveur.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Le 08/11/2020
 * @author Ngnawen Samuel
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto dto) {
        List<String> errors= UserValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Client non valide {}", dto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return UserDto.fromEntity(userRepository.save(UserDto.toEntity(dto)));
    }

    @Override
    public UserDto findById(Long id) {
        if(id==null){
            log.error("Client ID is null");
            return null;
        }

        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucune caegoriet avec le CODE= "+id+" n'a été trouvé dans la BD",
                        ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }



    /*@Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;*/

  /*  private static String currentUser=null;*/
    /*@Override
    public void save(User user) {
        userRepository.save(user);
    }*/

    /*@Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
*/
    /*@Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
*/
    /*@Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
*/
    /*@Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
*/
    /*@Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
*/
    /*@Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        currentUser=userDetails.getUsername();
        //System.out.println("userDetails.getUsername()+++> : " + userDetails.getUsername());
        return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
    }*/
/*
    @Override
    public MessageResponse registerUser(SignupRequest signUpRequest) {
        // Create new user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()),null);
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(RoleEnum.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return new MessageResponse("User registered successfully!");
    }
*/
}
