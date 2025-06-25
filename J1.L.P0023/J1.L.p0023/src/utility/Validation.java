package utility;
import java.util.Scanner;

public class Validation {
    private final static Scanner sc = new Scanner(System.in);

    public static String checkInputString(String s) {
    System.out.print(s);
    while (true) {
        s = sc.nextLine().trim();
        if (s.isEmpty()) {
            System.err.print("Input must not be empty. Enter again: ");
        } else {
            return s;
        }
    }
}
    public static int getInt(String prompt) {
    while (true) {
        String input = checkInputString(prompt);
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Please input an integer!");
        }
    }
}
    public static int checkInputIntLimit(String prompt, int min, int max) {
    while (true) {
        int result = getInt(prompt);  // sử dụng phương thức đã có
        if (result < min || result > max) {
            System.err.println("Please input number in range [" + min + ", " + max + "]");
        } else {
            return result;
        }
    }
}

public static double getDouble(String prompt) {
    while (true) {
        String input = checkInputString(prompt);
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            System.out.println("Please input a valid number (double)!");
        }
    }
}

public static boolean checkInputYN(String prompt) {
    while (true) {
        String input = checkInputString(prompt);
        if (input.equalsIgnoreCase("Y")) {
            return true;
        }
        if (input.equalsIgnoreCase("N")) {
            return false;
        }
        System.err.print("Please input Y or N. Enter again: ");
    }
}
}
