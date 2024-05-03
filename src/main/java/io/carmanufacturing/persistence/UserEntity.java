package io.carmanufacturing.persistence;

import io.carmanufacturing.entities.UserPermissions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_users")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    String name;

    String cpf;

    Date birth;

    String gender;

    boolean activeUser;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user-credentialsId_fk", nullable = false)
//    UserCredentialsPersistence userCredentials;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user-permissionsId_fk", nullable = false)
//    UserPermissions userPermissions;
}
