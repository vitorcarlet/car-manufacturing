package io.carmanufacturing.respositories;

import io.carmanufacturing.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByCpf(String cpf);

}
