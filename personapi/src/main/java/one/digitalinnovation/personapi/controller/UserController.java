package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public User findByUserName(@RequestParam String name) {
        return findBy(name);
    }

    User findBy(String name) {
        final User user = new User();
        user.setNome("joao");
        user.setSobrenome("Gomes");
        user.setPassword("12345");

        final List<User> users = Arrays.asList(user);

        return users.stream()
                .filter(item -> item.getNome().equals(name))
                .findFirst()
                .orElse(null);
    }
}
