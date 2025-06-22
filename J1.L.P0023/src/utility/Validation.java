package utility;
import java.util.Scanner;

public class Validation {
    private final static Scanner sc = new Scanner(System.in);

    // Check user input string (non-empty)
    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.print("Input must not be empty. Enter again: ");
            } else {
                return result;
            }
        }
    }
    // Lấy số nguyên
    public static int getInt() {
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine().trim());
                return number;
            } catch (Exception e) {
                System.out.println("Please input an integer!");
            }
        }
    }
    
    // Lấy số thực kiểu double
    public static double getDouble() {
        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine().trim());
                return number;
            } catch (Exception e) {
                System.out.println("Please input a valid number (double)!");
            }
        }
    }


    // Check input Y/N
    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.print("Please input Y or N. Enter again: ");
        }
    }
}
