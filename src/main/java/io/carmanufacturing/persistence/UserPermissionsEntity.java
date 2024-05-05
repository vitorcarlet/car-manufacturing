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

    @Column(name="isAdmin",nullable = false)
    boolean isAdmin;

    @Column(name="isOperator",nullable = false)
    boolean isOperator;

    @Column(name="isAssisant",nullable = false)
    boolean isAssistant;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId_fk", nullable = false)
    private UserEntity userId;

    public UserPermissionsEntity(boolean admin, boolean operator, boolean assistant) {
        this.isAdmin = admin;
        this.isOperator = operator;
        this.isAssistant = assistant;
    }
}