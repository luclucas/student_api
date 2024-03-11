package com.luluog.userapi;

import jakarta.annotation.PostConstruct;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @GetMapping("/")
    public String getMensagem() {
        return "Spring running";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf) {
        for (UserDTO userFilter : usuarios) {
            if (userFilter.getCpf().equals(cpf)) {
                return userFilter;
            }
        }
        return null;
    }

    @PutMapping("/newUser")
    UserDTO inserirUsuario(@RequestBody UserDTO userDTO){
        userDTO.setDataCadastro(new Date());
        usuarios.add(userDTO);
        return userDTO;
    }


    @PostConstruct
    public void initializeList() {
        UserDTO user1 = new UserDTO("joao",
                "1234", "sadfasdf",
                "qwer@mail.com", "12341234",
                new Date());


        UserDTO user2 = new UserDTO("pedro",
                "12345", "sadfasdf",
                "qwer@mail.com", "12341234",
                new Date());


        UserDTO user3 = new UserDTO("paulo",
                "123456", "sadfasdf",
                "qwer@mail.com", "12341234",
                new Date());


        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
    }
}
