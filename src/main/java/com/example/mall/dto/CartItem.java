package com.example.mall.dto;

public class CartItem {
    private int quantity;
    private String productName;
    private String image;

    public String getProductName() {return productName;}

    public void setProductName(String productName){ this.productName = productName; }
    public String getImage() {return image;}

    public void setImage(String image){ this.image = image;}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity =quantity;
    }


}
