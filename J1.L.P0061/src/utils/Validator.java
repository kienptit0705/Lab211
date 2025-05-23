/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class Validator {
    
    private static final Scanner sc  = new Scanner(System.in);
    
    //Check imput validation
    public static double getDouble(String message, int min, int max) {
        while(true) {
            try {
                //Input request message
                System.out.print(message);
                double number = Double.parseDouble(sc.nextLine());
                
                //Check number in range
                if(number > min && number <=max) {
                    return number;
                } else {
                    System.err.println("Please input number more than 0");
                }
                
            } catch (NumberFormatException e) {
                //Display error
                System.err.println("Please input a double number!");
            }
        }
    }
    
    
    //Check valid sides of a Triangle
    public static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && b + c > a && a + c > b;
    }
}
