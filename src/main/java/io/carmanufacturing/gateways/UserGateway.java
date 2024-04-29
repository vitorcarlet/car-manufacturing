package io.carmanufacturing.gateways;

import io.carmanufacturing.entities.User;

import java.util.List;

public interface UserGateway {

    User createUser(User user);

     User findByCpf(String cpf);

    List<User> obtainAllUsers();
}
