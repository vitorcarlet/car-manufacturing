package io.carmanufacturing.persistence;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@NamedQuery(name = "UserCredentialsEntity.findByUserId", query = "select new UserEntity(u.id,u.activeUser,u.birth,u.cpf,u.gender,u.name) from UserEntity u where u.id=:id")

@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "tb_userscredentials")
public class UserCredentialsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String senha;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId_fk", nullable = false)
    private UserEntity userId;

    public UserCredentialsEntity() {
    }

    public UserCredentialsEntity(String login, String senha, UserEntity user) {
        this.login = login;
        this.senha = senha;
        this.userId = user;
    }

    //testcommit



    public Collection<? extends GrantedAuthority> getAuthorities(UserPermissionsEntity userPermissions) {
        if (userPermissions.isAdmin == true) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }

        return List.of(
                new SimpleGrantedAuthority("ROLE_USER")
        );
    }


    public String getPassword() {
        return this.senha;
    }


    public String getUsername() {
        return this.login;
    }


    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return true;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }


    public boolean isEnabled() {
        return true;
    }
}
