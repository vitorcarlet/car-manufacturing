package io.carmanufacturing.persistence;

import io.carmanufacturing.entities.UserPermissions;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
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


    public UserEntity(String name, String cpf, Date birth, String gender, boolean activeUser) {
        this.name = name;
        this.cpf = cpf;
        this.birth = birth;
        this.gender = gender;
        this.activeUser = activeUser;
    }

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user-credentialsId_fk", nullable = false)
//    UserCredentialsEntity userCredentials;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user-permissionsId_fk", nullable = false)
//    UserPermissions userPermissions;
}
