/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thamlam;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.util.List;
public class Knapsack {
    private double capacity;
    private List<SelectedItem> selectedItems;
    private double totalValue;
    private double totalWeight;
    
    public Knapsack(double capacity) {
        if (capacity <=0){
            throw new IllegalArgumentException("Dung tích túi phải lớn hơn 0.");
        }
        this.capacity = capacity;
        this.selectedItems = new ArrayList<>();
        this.totalValue = 0;
        this.totalWeight = 0;
        
    }
    
    public void addItem(Item item, double weight){
        selectedItems.add(new SelectedItem(item, weight));
        totalValue += item.getValue()*(weight/item.getWeight());
        totalWeight += weight;
    }
    public double getTotalValue(){
        return totalValue;
    }
    public double getTotalWeight(){
        return totalWeight;
    }
    public void displaySelectedItems(){
        System.out.println("\nDanh sách các món đồ được chọn:");
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Ten mon", "Trong luong (kg)", "Gia tri (USD)", "Ty le gia tri/Trong luong");
        
        for (SelectedItem selected : selectedItems){
            System.out.printf("%-15s %-15.2f %-15.2f %-15.2f\n", 
            selected.getItem().getName(),
            selected.getWeight(),
            selected.getValue(),
            selected.getItem().getValuePerWeight());
        }
        System.out.printf("\nTonng trong luong: %.2f kg\n", totalWeight);
        System.out.printf("Tong gia tri: %.2f USD\n", totalValue);
    }
}
