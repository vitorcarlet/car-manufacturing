package io.carmanufacturing.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "tb_users_permissions")
public class UserPermissionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    boolean isAdmin;
    boolean isOperator;
    boolean isAssistant;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId_fk", nullable = false)
    private UserEntity userId;


    //    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user-credentialsId_fk", nullable = false)
//    UserCredentialsPersistence userCredentials;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user-permissionsId_fk", nullable = false)
//    UserPermissions userPermissions;
}