package io.carmanufacturing.respositories;

import io.carmanufacturing.persistence.UserCredentialsEntity;
import io.carmanufacturing.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentialsEntity, Long> {

    UserCredentialsEntity findByLogin(String login);

    UserEntity findByUserId(Long id);
}
