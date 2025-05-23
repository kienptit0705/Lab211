/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kien0
 */
public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(double wigth, double length) {
        this.width = wigth;
        this.length = length;
    }

    public double getWigth() {
        return width;
    }

    public void setWigth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return (length+width)*2;
    }

    @Override
    public double getArea() {
        return length*width;
    }

    @Override
    public void printResult() {
        System.out.printf("Triangle - Perimeter: %.2f, Area: %.2f\n", getPerimeter(), getArea());   
    }
    
}
