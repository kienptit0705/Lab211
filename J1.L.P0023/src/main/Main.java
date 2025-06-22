package main;
import controller.FruitShopController;
import utility.Validation;
import view.FruitView;

public class Main {
    public static void main(String[] args) {
        FruitShopController controller = new FruitShopController();
        boolean isExit = false;
        while (!isExit) {
            // Hiển thị menu bằng class view
            FruitView.menu();
            int option = Validation.getInt();
            switch (option) {
                case 1:
                    controller.createFruit();
                    break;
                case 2:
                    controller.viewOrders();
                    break;
                case 3:
                    controller.shopping();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    isExit = true;
                    break;
                default:
                    System.err.println("Invalid option. Please choose a number from 1 to 4.");
            }
        }
    }
}