package io.carmanufacturing.persistence;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@NamedQuery(name = "UserCredentialsEntity.findByUserId", query = "select new UserEntity(u.id,u.activeUser,u.birth,u.cpf,u.gender,u.name) from UserEntity u where u.id=:id")
@NamedQuery(name = "UserCredentialsEntity.findByLogin", query = "select new UserCredentialsEntity(u.id,u.login,u.senha,u.userId) from UserCredentialsEntity u where u.login=:login")

@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "tb_stock")
@NoArgsConstructor
@AllArgsConstructor
public class StockEntity   {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String category;

    @Column(nullable = false)
    protected float averageCost;

    @Column(nullable = false)
    protected float stockValue;

    @Column(nullable = false)
    protected float stockQuantity;

    @Column(nullable = false)
    protected float expectedStock;

    @Column(nullable = false)
    protected float commitedStock;



}
