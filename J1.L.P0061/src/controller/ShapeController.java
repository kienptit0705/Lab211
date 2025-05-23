package controller;

import dto.*;
import model.*;
import view.ShapeView;

import java.util.Scanner;

public class ShapeController {
    private ShapeView view = new ShapeView();
    private CircleDTO Cdto = new CircleDTO();
    private TriangleDTO Tdto = new TriangleDTO();
    private RectangleDTO Rdto = new RectangleDTO();
    private Scanner sc = new Scanner(System.in);

    public void inputCircleData() {
        while (true) {
            try {
                System.out.print("Enter radius of circle: ");
                double radius = Double.parseDouble(sc.nextLine());
                if (radius > 0) {
                    Cdto.setRadius(radius);
                    break;
                } else {
                    System.out.println("Radius must be positive.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void inputTriangleData() {
        while (true) {
            try {
                System.out.print("Enter side A of triangle: ");
                double a = Double.parseDouble(sc.nextLine());
                System.out.print("Enter side B of triangle: ");
                double b = Double.parseDouble(sc.nextLine());
                System.out.print("Enter side C of triangle: ");
                double c = Double.parseDouble(sc.nextLine());

                if (a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a) {
                    Tdto.setSideA(a);
                    Tdto.setSideB(b);
                    Tdto.setSideC(c);
                    break;
                } else {
                    System.out.println("Invalid triangle sides. Must be positive and satisfy triangle inequality.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers.");
            }
        }
    }

    public void inputRectangleData() {
        while (true) {
            try {
                System.out.print("Enter width of rectangle: ");
                double width = Double.parseDouble(sc.nextLine());
                System.out.print("Enter length of rectangle: ");
                double length = Double.parseDouble(sc.nextLine());

                if (width > 0 && length > 0) {
                    Rdto.setWidth(width);
                    Rdto.setLength(length);
                    break;
                } else {
                    System.out.println("Width and length must be positive.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers.");
            }
        }
    }

    public void handleCircle() {
        Shape circle = new Circle(Cdto.getRadius());
        view.display(circle);
    }

    public void handleTriangle() {
        Shape triangle = new Triangle(Tdto.getSideA(), Tdto.getSideB(), Tdto.getSideC());
        view.display(triangle);
    }

    public void handleRectangle() {
        Shape rectangle = new Rectangle(Rdto.getWidth(), Rdto.getLength());
        view.display(rectangle);
    }
}