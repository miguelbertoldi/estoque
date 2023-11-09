package net.weg.gerenciamentoestoque.model.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class ProductDTO {

    private String name;
    private Double value;
    private Integer quantity;
    private Date expirationDate;
    private String description;
    private Long barCode;
    private Double weight;
    private Double measure;
    private String manufacturer;
    private String category;

}
