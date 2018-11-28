package com.example;

public class Calculator {
   public void add(int a, int b) {
      System.out.println("Called by add()");
      System.out.println(String.format("%d + %d = %d",a,b,(a+b)));
   }
   public void subtract(int a, int b) {
      System.out.println("Called by subtract()");
      System.out.println(String.format("%d - %d = %d",a,b,(a-b)));
   }
   public void multiply(int a, int b) {
      System.out.println("Called by multiply()");
      System.out.println(String.format("%d X %d = %d",a,b,(a*b)));
   }
   public void divide(int a, int b) {
      System.out.println("Called by divide()");
      System.out.println(String.format("%d / %d = %d",a,b,(a/b)));
   }
}