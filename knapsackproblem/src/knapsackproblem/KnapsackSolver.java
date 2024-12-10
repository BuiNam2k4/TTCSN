package knapsackproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnapsackSolver {
    private Item[] items;
    private int capacity;

    // Phương thức nhập dữ liệu 
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        // Vòng lặp nhập số lượng vật phẩm
        int n = 0;
        do {
            try {
                System.out.print("Nhap so luong vat pham: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    throw new KnapsackException("So luong vat pham phai lon hon 0!");
                }
                validInput = true;
            } catch (KnapsackException | NumberFormatException e) {
                System.err.println("Loi: " + e.getMessage() + " Vui long nhap lai.");
            }
        } while (!validInput);

        // Khởi tạo danh sách vật phẩm
        items = new Item[n];
        for (int i = 0; i < n; i++) {
            validInput = false;
            do {
                try {
                    System.out.println("Nhap thong tin cho vat pham " + (i + 1) + ":");
                    System.out.print("- Ten vat pham: ");
                    String name = scanner.nextLine();
                    System.out.print("- Trong luong: ");
                    int weight = Integer.parseInt(scanner.nextLine());
                    System.out.print("- Gia tri: ");
                    int value = Integer.parseInt(scanner.nextLine());

                    if (weight <= 0 || value < 0) {
                        throw new KnapsackException("Trong luong phai lon hon 0 va gia tri khong duoc am!");
                    }

                    items[i] = new Item(name, weight, value);
                    validInput = true;
                } catch (KnapsackException | NumberFormatException e) {
                    System.err.println("Loi: " + e.getMessage() + " Vui long nhap lai.");
                }
            } while (!validInput);
        }

        // Vòng lặp nhập sức chứa của túi
        validInput = false;
        do {
            try {
                System.out.print("Nhap suc chua cua tui: ");
                capacity = Integer.parseInt(scanner.nextLine());
                if (capacity <= 0) {
                    throw new KnapsackException("Suc chua cua tui phai lon hon 0!");
                }
                validInput = true;
            } catch (KnapsackException | NumberFormatException e) {
                System.err.println("Loi: " + e.getMessage() + " Vui long nhap lai.");
            }
        } while (!validInput);
    }

    // Phương thức giải bài toán
    public int solveKnapsack() {
        int n = items.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Điền bảng DP
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (items[i - 1].getWeight() <= w) {
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        dp[i - 1][w - items[i - 1].getWeight()] + items[i - 1].getValue()
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Truy vết ngược để tìm danh sách vật phẩm được chọn
        List<Item> selectedItems = new ArrayList<>();
        int w = capacity;
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems.add(items[i - 1]);
                w -= items[i - 1].getWeight();
            }
        }

        // Hiển thị bảng DP chi tiết
        System.out.println("\nBang DP chi tiet:");
        System.out.println("-------------------------------------------------------");
        System.out.print("i/w\t");
        for (int weight = 0; weight <= capacity; weight++) {
            System.out.print(weight + "\t");
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print("0\t");
            } else {
                System.out.print("[" + items[i - 1].getWeight() + "," + items[i - 1].getValue() + "]\t");
            }
            for (int weight = 0; weight <= capacity; weight++) {
                System.out.print(dp[i][weight] + "\t");
            }
            System.out.println();
        }

        // Hiển thị danh sách các vật phẩm được chọn
        System.out.println("\nDanh sach vat pham duoc chon:");
        int totalWeight = 0;
        for (Item item : selectedItems) {
            System.out.println("- Ten: " + item.getName() + ", Trong luong: " + item.getWeight() + ", Gia tri: " + item.getValue());
            totalWeight += item.getWeight();
        }

        // Hiển thị tổng khối lượng và giá trị
        System.out.println("\nTong khoi luong: " + totalWeight);
        System.out.println("Tong gia tri toi da: " + dp[n][capacity]);

        return dp[n][capacity];
    }
}