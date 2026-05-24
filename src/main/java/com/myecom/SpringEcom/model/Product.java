package com.myecom.SpringEcom.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "Product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private Long price;
    private String category;
    private LocalDate releaseDate;
    private boolean productAvailable;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;
    private int stockQuantity;

}
