package io.carmanufacturing.persistence;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
