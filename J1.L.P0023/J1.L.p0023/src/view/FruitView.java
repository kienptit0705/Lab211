package view;

import java.util.ArrayList;
import java.util.HashMap;

public class FruitView {

    private String header;
    private ArrayList<String> list;
    private HashMap<String, Integer> map;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public void displayHeader() {
        System.out.println(header);
    }

    public void displayList() {
        //System.out.println("\n-------List Info--------");
        for (String item : list) {
            System.out.println(item);
        }
    }

    //Show menu
    public static void menu() {
        System.out.println("--FRUIT SHOP SYSTEM--");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
    }
}
