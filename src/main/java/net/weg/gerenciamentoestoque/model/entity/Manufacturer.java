package net.weg.gerenciamentoestoque.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_manufacturer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,
            length = 30)
    private String name;

    @Column(length = 100)
    private String description;

}
