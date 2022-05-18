package br.com.dani.mentoria_pp.controller;

import br.com.dani.mentoria_pp.dto.UserDto;
import br.com.dani.mentoria_pp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok(Map.of("message", "Created User"));
    }
}
