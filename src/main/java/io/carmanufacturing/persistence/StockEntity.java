package io.carmanufacturing.persistence;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class StockEntity   {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String cateogyr;

    @Column(nullable = false)
    protected float custoMedio;

    @Column(nullable = false)
    protected float valorNoEstoque;

    @Column(nullable = false)
    protected float QuantidadeNoEstoque;

    @Column(nullable = false)
    protected float EsperadoChegarNoEstoque;

    @Column(nullable = false)
    protected float ComprometidoAChegarNoEstoque;

    //@Column(nullable = false)
    //PontoDeRecompra float pontoDeRecompra;

    @Column(nullable = false)
    protected float faltandoOrExcesso;



    public StockEntity() {
    }

    public StockEntity(Long id, String name, String cateogyr, float custoMedio, float valorNoEstoque, float quantidadeNoEstoque, float esperadoChegarNoEstoque, float comprometidoAChegarNoEstoque, float pontoDeRecompra, float faltandoOrExcesso) {
        this.id = id;
        this.name = name;
        this.cateogyr = cateogyr;
        this.custoMedio = custoMedio;
        this.valorNoEstoque = valorNoEstoque;
        QuantidadeNoEstoque = quantidadeNoEstoque;
        EsperadoChegarNoEstoque = esperadoChegarNoEstoque;
        ComprometidoAChegarNoEstoque = comprometidoAChegarNoEstoque;
        //this.pontoDeRecompra = pontoDeRecompra;
        this.faltandoOrExcesso = faltandoOrExcesso;
    }
}
