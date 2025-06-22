package controller;

import java.util.ArrayList;
import model.Fruit;
import service.FruitService;
import view.FruitView;
import utility.Validation;

public class FruitShopController {
    // Danh sách sản phẩm do chủ cửa hàng tạo
    private ArrayList<Fruit> fruitList;
    // Dịch vụ quản lý đơn hàng
    private FruitService orderService;
    // View để hiển thị thông tin
    private FruitView fruitView;
    
    public FruitShopController() {
        fruitList = new ArrayList<>();
        orderService = new FruitService();
        fruitView = new FruitView();
    }
    
    // Phương thức tạo sản phẩm
    public void createFruit() {
        boolean cont = true;
        while (cont) {
            System.out.print("Enter Fruit ID: ");
            String id = Validation.checkInputString();
            System.out.print("Enter Fruit Name: ");
            String name = Validation.checkInputString();
            System.out.print("Enter Price: ");
            double price = Validation.getDouble();
            System.out.print("Enter Quantity: ");
            int quantity = Validation.getInt();
            System.out.print("Enter Origin: ");
            String origin = Validation.checkInputString();
            
            Fruit fruit = new Fruit(id, name, price, quantity, origin);
            fruitList.add(fruit);
            
            System.out.print("Do you want to continue (Y/N): ");
            cont = Validation.checkInputYN();
        }
        // Hiển thị danh sách quả đã tạo
        fruitView.setHeader("Fruit List:");
        ArrayList<String> fruitInfo = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            fruitInfo.add(fruit.toString());
        }
        fruitView.setList(fruitInfo);
        fruitView.displayHeader();
        fruitView.displayList();
    }
    
    // Phương thức hiển thị báo cáo đơn hàng từ OrderService
    public void viewOrders() {
        fruitView.setHeader("Order Report:");
        fruitView.setMap(orderService.getMapReport());
        fruitView.displayHeader();
        fruitView.displayReport();
    }
    
    // Phương thức xử lý mua hàng
    public void shopping() {
        if (fruitList.isEmpty()) {
            System.out.println("No fruits available. Please create fruits first.");
            return;
        }
        boolean continueShopping = true;
        while (continueShopping) {
            // Hiển thị danh sách các loại quả có sẵn
            System.out.println("\nFruit List:");
            for (int i = 0; i < fruitList.size(); i++) {
                Fruit f = fruitList.get(i);
                System.out.printf("%d. %s | %s | $%.2f | Available: %d\n", 
                                  (i + 1), f.getName(), f.getOrigin(), f.getPrice(), f.getQuantity());
            }
            System.out.print("Select an item by number: ");
            int selection = Validation.getInt();
            if (selection < 1 || selection > fruitList.size()) {
                System.err.println("Invalid selection. Try again.");
                continue;
            }
            Fruit selectedFruit = fruitList.get(selection - 1);
            System.out.println("You selected: " + selectedFruit.getName());
            System.out.print("Enter quantity: ");
            int orderQty = Validation.getInt();
            if (orderQty > selectedFruit.getQuantity()) {
                System.err.println("Not enough fruit in stock. Available: " + selectedFruit.getQuantity());
            } else {
                // Giảm số lượng tồn kho của sản phẩm
                selectedFruit.setQuantity(selectedFruit.getQuantity() - orderQty);
                // Tạo đối tượng Fruit mới biểu diễn đơn hàng với số lượng đặt mua là orderQty
                Fruit orderFruit = new Fruit(selectedFruit.getId(), selectedFruit.getName(),
                                             selectedFruit.getPrice(), orderQty, selectedFruit.getOrigin());
                orderService.addFruit(orderFruit);
                System.out.print("Do you want to order now (Y/N): ");
                if (Validation.checkInputYN()) {
                    continueShopping = false;
                }
            }
        }
        // Hiển thị tóm tắt đơn hàng
        System.out.println("\nCurrent Order Summary:");
        System.out.println("Fruit               | Total Quantity");
        fruitView.setMap(orderService.getMapReport());
        fruitView.displayReport();
    }
}