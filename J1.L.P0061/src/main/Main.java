/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.ShapeController;

/**
 *
 * @author kien0
 */
public class Main {
    public static void main(String[] args) {
        ShapeController controller = new ShapeController();

        System.out.println("=== CIRCLE ===");
        controller.inputCircleData();
        controller.handleCircle();

        System.out.println("\n=== RECTANGLE ===");
        controller.inputRectangleData();
        controller.handleRectangle();

        System.out.println("\n=== TRIANGLE ===");
        controller.inputTriangleData();
        controller.handleTriangle();
    }
}
