package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import model.*;
import service.OrderService;
import view.FruitView;

public class FruitShopController {

    private OrderService orderService = new OrderService();
    private FruitView fruitView = new FruitView();
    private Fruit fruit = new Fruit();

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(String id, String name, double price, int quantity, String origin) {
        fruit.setId(id);
        fruit.setName(name);
        fruit.setPrice(price);
        fruit.setQuantity(quantity);
        fruit.setOrigin(origin);
    }

    public static void displayMenu() {
        FruitView.menu();
    }

    public FruitShopController() {
    }

    public void geneTest() {
        orderService.addFruit(new Fruit("F01", "Apple", 10.0, 20, "USA"));
        orderService.addFruit(new Fruit("F02", "Orange", 8.5, 15, "Spain"));
        orderService.addFruit(new Fruit("F03", "Banana", 5.0, 30, "Vietnam"));
    }

    // Phương thức createFruit
    public void createFruit(Fruit fru) {
        ArrayList<Fruit> fruitList = orderService.getListFruit();
        String fruId = fru.getId();
        if (orderService.checkIdExist(fruitList, fruId)) {
            fruitView.setHeader("Id exist");
            fruitView.displayHeader();
            return;
        }
        fruitList.add(fru);
        fruitView.setHeader("Create success");
        fruitView.displayHeader();
    }

    public void displayListFruit() {
        ArrayList<Fruit> fruitList = orderService.getListFruit();
        ArrayList<String> result = new ArrayList<>();
        if (fruitList.isEmpty()) {
            fruitView.setHeader("No fruits available.");
            fruitView.displayHeader();
            return;
        }
        result.add(String.format("%10s|%10s|%10s|%10s", "Item", "Fruit Name", "Origin", "Price"));
        int index = 1;
        for (Fruit f : fruitList) {
            if (f.getQuantity() > 0) {
                result.add(String.format("%10d|%10s|%10s|%10.2f",
                        index++, f.getName(), f.getOrigin(), f.getPrice()));
            }
        }
        fruitView.setList(result);
        fruitView.displayList();
    }

    public void displayListOrder() {
        ArrayList<Order> listOrder = orderService.getListOrder();
        ArrayList<String> result = new ArrayList<>();
        double total = 0;
        result.add(String.format("%10s|%10s|%10s|%10s",
                "Product", "Quantity", "Price", "Amount"));
        int idx = 1;
        for (Order order : listOrder) {
            String product = order.getFruit().getName();
            int quantity = order.getQuantity();
            double price = order.getFruit().getPrice();
            double amount = quantity * price;
            result.add(String.format("%5d%s|%10s|%10.2f|%10.2f",
                    idx++, "." + product, quantity, price, amount));
            total += amount;
        }
        fruitView.setList(result);
        fruitView.displayList();
    }

// FruitShopController.java
    public void viewOrders() {
        Hashtable<String, ArrayList<Order>> tableOrder = orderService.getTableOrder();
        if (tableOrder.isEmpty()) {
            fruitView.setHeader("No orders have been placed.");
            fruitView.displayHeader();
            return;
        }

        for (String customer : tableOrder.keySet()) {
            fruitView.setHeader("\nCustomer: " + customer);
            fruitView.displayHeader();

            // build trực tiếp bảng cho từng khách
            ArrayList<Order> orders = tableOrder.get(customer);
            ArrayList<String> result = new ArrayList<>();
            result.add(String.format("%10s|%10s|%10s|%10s",
                    "Product", "Quantity", "Price", "Amount"));
            double total = 0;
            int idx = 1;
            for (Order order : orders) {
                String product = order.getFruit().getName();
                int qty = order.getQuantity();
                double price = order.getFruit().getPrice();
                double amt = qty * price;
                result.add(String.format("%3d%7s|%10s|%10.2f|%10.2f",
                        idx++, "." + product, qty, price, amt));
                total += amt;
            }
            fruitView.setList(result);
            fruitView.displayList();
            fruitView.setHeader("Total: " + total + "$");
            fruitView.displayHeader();
        }
    }

    public void updateOrder(String id, int quantity) {
        ArrayList<Order> listOrder = orderService.getListOrder();
        for (Order order : listOrder) {
            if (order.getFruit().getId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

    // FruitShopController.java
    public Fruit getFruitByItem(int item) {
        ArrayList<Fruit> fruitList = orderService.getListFruit();
        int idx = 1;
        for (Fruit f : fruitList) {
            if (f.getQuantity() > 0) {
                if (idx == item) {
                    return f;
                }
                idx++;
            }
        }
        return null;
    }

// FruitShopController.java
    public void shopping(String customerName, int item, int orderQuantity) {
        ArrayList<Fruit> fruitList = orderService.getListFruit();
        Hashtable<String, ArrayList<Order>> tableOrder = orderService.getTableOrder();
        Fruit selectedFruit = getFruitByItem(item);

        if (selectedFruit == null) {
            fruitView.setHeader("Invalid item selected.");
            fruitView.displayHeader();
            return;
        }
        if (orderQuantity <= 0 || selectedFruit.getQuantity() < orderQuantity) {
            fruitView.setHeader("Invalid quantity.");
            fruitView.displayHeader();
            return;
        }

        // 1) trừ số lượng, xóa fruit nếu về 0
        orderService.updateFruitQuantityAfterOrder(selectedFruit.getId(), orderQuantity);
        orderService.removeFruitIfEmpty(selectedFruit.getId());

        // 2) lấy/khởi tạo giỏ cho khách
        ArrayList<Order> customerOrders = tableOrder.getOrDefault(customerName, new ArrayList<>());

        // 3) gộp item nếu đã có
        boolean found = false;
        for (Order o : customerOrders) {
            if (o.getFruit().getId().equalsIgnoreCase(selectedFruit.getId())) {
                o.setQuantity(o.getQuantity() + orderQuantity);
                found = true;
                break;
            }
        }
        if (!found) {
            customerOrders.add(new Order(selectedFruit, orderQuantity));
        }

        // 4) cập nhật lại map
        tableOrder.put(customerName, customerOrders);

        fruitView.setHeader("Added to cart successfully.");
        fruitView.displayHeader();
    }
}
