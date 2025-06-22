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

    public void setMap(HashMap<String, Integer> map) {
        this.map = map;
    }    


    public void displayHeader(){
        if(header.contains("success"))
        System.out.println(header);
        else System.err.println(header);
    }
    public void displayList() {
        //System.out.println("\n-------List Info--------");
        for (String item : list) {
            System.out.println(item);
        }
    }

    public void displayReport() {
        //System.out.println("\n-------Report Info--------");
        for (String key : map.keySet()) {
            System.out.printf("%s|%20d\n", key, map.get(key));
        }
    }
    //Show menu
    public static void menu() {
        System.out.println("\n------------------------------");
        System.out.println("       FRUIT SHOP SYSTEM      ");
        System.out.println("------------------------------");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program: ");
    }


  
}
