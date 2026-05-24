package com.myecom.SpringEcom.model;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;


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
