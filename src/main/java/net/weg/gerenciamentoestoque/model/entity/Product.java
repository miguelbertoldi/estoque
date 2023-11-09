package net.weg.gerenciamentoestoque.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tb_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,
            length = 30)
    private String name;
    private Double value;
    private Integer quantity;

    @Column(nullable = false)
    private Date expirationDate;

    @Column(length = 100,
            nullable = false)
    private String description;

    @Column(nullable = false)
    private Long barCode;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double measure;

    @Column(length = 30,
            nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String category;

}
