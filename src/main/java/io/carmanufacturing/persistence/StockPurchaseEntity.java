package io.carmanufacturing.persistence;

import io.carmanufacturing.entities.RepurchasePoint;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "tb_stock_purchase_entity")
@NoArgsConstructor
@AllArgsConstructor
public class StockPurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date purchaseDate;

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String category;
    @Column(nullable = false)
    float cost;
    @Column(nullable = false)
    float quantity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "repurchasePointId_fk", nullable = false)
    RepurchasePoint repurchasePoint;
}
