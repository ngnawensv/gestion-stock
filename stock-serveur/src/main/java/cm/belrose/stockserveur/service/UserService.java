package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.ClientDto;
import cm.belrose.stockserveur.dto.UserDto;
import cm.belrose.stockserveur.model.User;
import cm.belrose.stockserveur.payload.request.LoginRequest;
import cm.belrose.stockserveur.payload.request.SignupRequest;
import cm.belrose.stockserveur.payload.response.JwtResponse;
import cm.belrose.stockserveur.payload.response.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto save(UserDto dto);

    UserDto findById(Long id);

    List<UserDto> findAll() ;

    void delete(Long id);

    //void save(User user);

   // Optional<User> findById(Long id);

   // List<User> findAll();

   // Optional<User> findUserByUsername(String username);

    //Boolean existsByUsername(String username);

    //Boolean existsByEmail(String email);

     //JwtResponse authenticateUser(LoginRequest loginRequest);

   //  MessageResponse registerUser(SignupRequest signUpRequest);

}
