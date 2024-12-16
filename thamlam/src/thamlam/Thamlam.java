/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package thamlam;

/**
 *
 * @author Admin
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Lớp chính
public class Thamlam {
    public static void main(String[] args) {
        try{
            // Tạo một mảng các vật phẩm
            List<Item> items = new ArrayList<>();
            items.add(new Item("Dong ho", 5, 50));
            items.add(new Item("May tinh", 10, 60));
            items.add(new Item("Go quy", 20, 140));
            items.add(new Item("Tuong", 25, 100));
            items.add(new Item("Tivi", 15, 40));
            
            // Hiển thị danh sách cố định
            System.out.println("Danh sách món hàng mặc định:");
            for (Item item : items) {
                System.out.println(item);
            }
             // Bổ sung món hàng từ bàn phím
            List<Item> additionalItems = inputItems();
            items.addAll(additionalItems); // Gộp danh sách cố định và danh sách nhập thêm

            //kiểm tra danh sach rỗng
            if (items.isEmpty()){
                throw new IllegalStateException("Danh sách món hàng trống.");
            }
             // Sắp xếp món đồ theo tỷ lệ giá trị/trọng lượng giảm dần
            Collections.sort(items);

            // Nhập dung tích túi từ người dùng
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nNhập dung tích của túi (kg): ");
            double capacity = scanner.nextDouble();
            if (capacity <= 0) {
                throw new IllegalArgumentException("Dung tích túi phải lớn hơn 0.");
            }
            Knapsack knapsack = new Knapsack(capacity);

            for (Item item : items){
                if(capacity <= 0) break;

                //Nếu đủ chỗ, lấy toàn bộ món đồ
                if(item.getWeight() <= capacity){
                    knapsack.addItem(item, item.getWeight());
                    capacity -= item.getWeight();
                }
                // Nếu không đủ chỗ, lấy một phần món đồ
                //else {
                  //  knapsack.addItem(item, capacity);
                    //capacity = 0;
                //}
            }
         // Kết quả
        System.out.println("Danh sách các món đồ được chọn:");
        knapsack.displaySelectedItems();
        }
    catch (IllegalArgumentException | NullPointerException | IllegalStateException e){
        System.err.println("Lỗi: " + e.getMessage());
    }catch (Exception e){
        System.err.println("Đã xảy ra lỗi không xác định: " + e.getMessage());
    }
 }
    /**
     * Hàm để nhập danh sách các món hàng từ người dùng.
     *
     * @return Danh sách các món hàng.
     */
    public static List<Item> inputItems() {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();
        
         try {
        System.out.print("\nNhập số lượng món hàng cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n < 0) {
            throw new IllegalArgumentException("Số lượng món hàng phải lớn hơn hoặc bằng 0.");
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("\nNhập thông tin món hàng thứ " + i + ":");

            System.out.print("Tên món hàng: ");
            String name = scanner.nextLine();

            System.out.print("Trọng lượng (kg): ");
            double weight = Double.parseDouble(scanner.nextLine());
            if (weight <= 0) {
                throw new IllegalArgumentException("Trọng lượng phải lớn hơn 0.");
            }

            System.out.print("Giá trị (USD): ");
            double value = Double.parseDouble(scanner.nextLine());
            if (value <= 0) {
                throw new IllegalArgumentException("Giá trị phải lớn hơn 0.");
            }

            items.add(new Item(name, weight, value));
        }
    } catch (NumberFormatException e) {
        System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
    } catch (IllegalArgumentException e) {
        System.out.println("Lỗi: " + e.getMessage());
    }

    return items;
    }
}