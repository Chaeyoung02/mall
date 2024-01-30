package com.example.mall.dto;

import jdk.jshell.execution.JdiExecutionControl;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ProductDTO {
    private int product_id;
    private String name;
    private int price;
    private String image;
    private String description;

    public ProductDTO(int product_id, String name, int price,  String image, String description) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;

    }
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void getPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
