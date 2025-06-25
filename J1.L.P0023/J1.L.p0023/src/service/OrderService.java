package service;

import java.util.ArrayList;
import java.util.Hashtable;
import model.*;

public class OrderService {

    private ArrayList<Fruit> listFruit = new ArrayList<>();
    private ArrayList<Order> listOrder = new ArrayList<>();
    private Hashtable<String, ArrayList<Order>> tableOrder = new Hashtable<>();

    public OrderService() {
    }

    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public Hashtable<String, ArrayList<Order>> getTableOrder() {
        return tableOrder;
    }
    public int getSize(){
        return listFruit.size();
    }
    public void addFruit(Fruit fruit) {
        listFruit.add(fruit);
    }

    public static boolean checkIdExist(ArrayList<Fruit> listFruit, String id) {
        for (Fruit fruit : listFruit) {
            if (id.equalsIgnoreCase(fruit.getId())) {
                return true;
            }
        }
        return false;
    }

    //check item exist or not
    public static boolean checkItemExist(ArrayList<Order> listOrder, String id) {
        for (Order order : listOrder) {
            if (id.equalsIgnoreCase(order.getFruit().getId())) {
                return true;
            }
        }
        return false;
    }

    public void updateFruitQuantityAfterOrder(String fruitId, int quantityOrdered) {
        for (Fruit fruit : listFruit) {
            if (fruit.getId().equalsIgnoreCase(fruitId)) {
                int newQuantity = fruit.getQuantity() - quantityOrdered;
                fruit.setQuantity(newQuantity);
                break;
            }
        }
    }

    public void removeFruitIfEmpty(String fruitId) {
        for (int i = 0; i < listFruit.size(); i++) {
            Fruit fruit = listFruit.get(i);
            if (fruit.getId().equalsIgnoreCase(fruitId)) {
                if (fruit.getQuantity() <= 0) {
                    listFruit.remove(i);
                    break; // Sau khi xóa, thoát khỏi vòng lặp luôn
                } else {
                    // Nếu số lượng vẫn còn, không cần làm gì cả
                    break;
                }
            }
        }
    }
    
    
}
