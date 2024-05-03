package io.carmanufacturing.respositories;

import io.carmanufacturing.persistence.UserCredentialsPersistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentialsPersistence, Long> {

    UserCredentialsPersistence findByLogin(String login);
}
