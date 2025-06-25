package main;

import controller.FruitShopController;
import utility.Validation;

public class Main {

    public static void main(String[] args) {
        FruitShopController conFruit = new FruitShopController();
        int choice;
        conFruit.geneTest();
//        conFruit.shopping("1", 1, 1);
//        conFruit.shopping("2", 2, 1);
//        conFruit.shopping("1", 2, 1);
//        conFruit.shopping("2", 3, 1);
//        conFruit.displayListFruit();
//        conFruit.displayListOrder();
//        conFruit.viewOrders();
        do{
            conFruit.displayMenu();
            choice = Validation.checkInputIntLimit("Enter choice (1–4): ", 1, 4);
            switch (choice) {
                case 1:
                    while(true){
                    String id = Validation.checkInputString("Enter Fruit ID: ");
                    String name = Validation.checkInputString("Enter Fruit Name: ");
                    double price = Validation.getDouble("Enter Price: ");
                    int quantity = Validation.getInt("Enter Quantity: ");
                    String origin = Validation.checkInputString("Enter Origin: ");
                    conFruit.setFruit(id, name, price, quantity, origin);
                    conFruit.createFruit(conFruit.getFruit());
                    if(!Validation.checkInputYN("Do you want to continue (Y/N): ")) break; 
                    }break;
                case 2:
                    conFruit.viewOrders();
                    break;
                case 3:
                    conFruit.displayListFruit();
                    while(true){
                    String customerName=Validation.checkInputString("Enter customer name: ");
                    int item = Validation.getInt("Enter Item: "); 
                    int quantity = Validation.getInt("Enter Quantity: "); 
                    conFruit.shopping(customerName, item, quantity);
                    if(!Validation.checkInputYN("Do you want to continue (Y/N): ")) break; 
                    }
                    break;
                case 4:
                    return;
            }
        }while (choice > 0 && choice < 5) ;
    }
}
