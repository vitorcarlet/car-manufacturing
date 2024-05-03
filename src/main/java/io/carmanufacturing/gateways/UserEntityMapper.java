package io.carmanufacturing.gateways;

import io.carmanufacturing.entities.User;
import io.carmanufacturing.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.id(),user.name(), user.cpf(), user.birth(),user.gender(),user.activeUser());
    }

    public User toUser(UserEntity entity) {
        return new User(entity.getId(), entity.getName(), entity.getCpf(), entity.getBirth(), entity.getGender(),entity.isActiveUser());
    }
}
