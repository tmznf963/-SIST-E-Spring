package com.example;

public class Product {
   private String pName;
   private int pPrice;
   private String maker;
   private String color;
   
   public Product(String pName, int pPrice) {
      this.pName = pName;
      this.pPrice = pPrice;
   }

   public void setMaker(String maker) {
      this.maker = maker;
   }

   public void setColor(String color) {
      this.color = color;
   }

   @Override
   public String toString() {
      return "Product [pName=" + pName + ", pPrice=" + pPrice + ", maker=" + maker + ", color=" + color + "]";
   }
}