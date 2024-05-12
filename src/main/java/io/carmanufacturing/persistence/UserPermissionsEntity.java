package io.carmanufacturing.persistence;

import io.carmanufacturing.dtos.UserPermissionsDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@NamedQuery(name = "UserPermissionsEntity.findByUserId", query = "select new UserEntity(u.id,u.activeUser,u.birth,u.cpf,u.gender,u.name) from UserEntity u where u.id=:id")


@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "tb_users_permissions")
public class UserPermissionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="isAdmin")
    boolean isAdmin;

    @Column(name="isOperator")
    boolean isOperator;

    @Column(name="isAssistant")
    boolean isAssistant;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId_fk")
    private UserEntity userId;

    public UserPermissionsEntity() {
    }

    public UserPermissionsEntity(boolean admin, boolean operator, boolean assistant, UserEntity user) {
        this.isAdmin = admin;
        this.isOperator = operator;
        this.isAssistant = assistant;
        this.userId = user;
    }
}