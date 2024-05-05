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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name= "cpf",nullable = false)
    String cpf;

    @Column(name="birth",nullable = false)
    Date birth;

    @Column(name="gender",nullable = false)
    String gender;

    @Column(name="activeUser",nullable = false)
    boolean activeUser;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_permission_Id_fk", nullable = false)
    private UserPermissionsEntity userPermissionsEntity;

    public UserEntity(String name, String cpf, Date birth, String gender, boolean activeUser, UserPermissionsEntity userPermissions) {
        this.name = name;
        this.cpf = cpf;
        this.birth = birth;
        this.gender = gender;
        this.activeUser = activeUser;
        this.userPermissionsEntity = userPermissions;
    }

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user-credentialsId_fk", nullable = false)
//    UserCredentialsEntity userCredentials;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user-permissionsId_fk", nullable = false)
//    UserPermissions userPermissions;
}
