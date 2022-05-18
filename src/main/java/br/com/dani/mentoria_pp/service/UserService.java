package br.com.dani.mentoria_pp.service;

import br.com.dani.mentoria_pp.dto.UserDto;
import br.com.dani.mentoria_pp.model.User;
import br.com.dani.mentoria_pp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDto userDto) {
        var userEntity = new User(
                null,
                userDto.getEmail(),
                userDto.getPassword()
        );

        userRepository.save(userEntity);

    }
}
