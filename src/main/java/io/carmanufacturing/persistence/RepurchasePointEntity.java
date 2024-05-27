package io.carmanufacturing.persistence;

import io.carmanufacturing.entities.Adress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "tb_repurchase_point")
@NoArgsConstructor
@AllArgsConstructor
public class RepurchasePointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adressId_fk", nullable = false)
    Adress adress;
}
