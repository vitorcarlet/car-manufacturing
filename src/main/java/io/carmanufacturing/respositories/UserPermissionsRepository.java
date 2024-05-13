package io.carmanufacturing.respositories;

import io.carmanufacturing.persistence.UserCredentialsEntity;
import io.carmanufacturing.persistence.UserEntity;
import io.carmanufacturing.persistence.UserPermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionsRepository  extends JpaRepository<UserPermissionsEntity, Long> {

    //UserPermissionsEntity findByLogin(String login);


    UserCredentialsEntity findByLogin(String login);
    UserPermissionsEntity findByUserCredentialsId(Long id);
}
