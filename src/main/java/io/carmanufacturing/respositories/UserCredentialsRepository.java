package io.carmanufacturing.respositories;

import io.carmanufacturing.entities.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {

    UserCredentials findByLogin(String login);
}
