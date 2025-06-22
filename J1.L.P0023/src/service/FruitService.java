package service;

import java.util.ArrayList;
import java.util.HashMap;
import model.Fruit; // Giả sử lớp Fruit được định nghĩa trong package model

public class FruitService {
    // Danh sách các Fruit mà khách hàng đã mua (mỗi Fruit có số lượng tương ứng)
    private ArrayList<Fruit> listFruit=listFruit = new ArrayList<>();;
    // Bản đồ lưu báo cáo: key là định dạng "ID|Tên Quả" (theo yêu cầu) và value là tổng số lượng mua
    private HashMap<String, Integer> mapOrder= new HashMap<>();
    
    // Constructor khởi tạo
    public FruitService() {}
    
    // Phương thức thêm quả vào danh sách đặt mua
    public void addFruit(Fruit fruit) {
        listFruit.add(fruit);
    }
    
    // Lấy danh sách các Fruit khách hàng đã đặt mua (nếu cần dùng riêng)
    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }
    
    /**
     * Phương thức getMapReport:
     * Duyệt qua danh sách listFruit, tạo khóa cho mỗi quả được mua theo định dạng:
     *   String reportKey = String.format("%10s|%10s", fruit.getId(), fruit.getName());
     * Sau đó cộng dồn số lượng của mỗi loại quả vào mapOrder.
     */
    public HashMap<String, Integer> getMapReport() {
        // Xoá dữ liệu cũ trong mapOrder để cập nhật lại báo cáo mới
        mapOrder.clear();
        // Duyệt qua từng Fruit trong listFruit
        for (Fruit fruit : listFruit) {
            // Tạo khóa cho report: kết hợp ID và Tên Quả theo định dạng cố định.
            String key = String.format("%10s|%10s", fruit.getId(), fruit.getName());
            // Cộng dồn số lượng: nếu key đã tồn tại thì cộng thêm số lượng, nếu chưa thì khởi tạo với số lượng hiện tại.
            mapOrder.put(key, mapOrder.getOrDefault(key, 0) + fruit.getQuantity());
        }
        return mapOrder;
    }
}