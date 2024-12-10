/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thamlam;

/**
 *
 * @author Admin
 */
public class Item implements Comparable<Item>{
    private String name;
    private double weight;
    private double value;
    
    public Item(String name, double weight, double value) {
        if (weight <=0){
            throw new IllegalArgumentException("Trọng lượng phải lớn hơn 0.");
        }
        if (value <= 0){
            throw new IllegalArgumentException("Giá trị phải lớn hơn 0.");
        }
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
    public String getName(){
        return name;
    }
    
    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    // Tỷ lệ giá trị/trọng lượng
    public double getValuePerWeight() {
        return value / weight;
    }
    
    @Override
    public int compareTo(Item other){
        // Sắp xếp theo tỷ lệ giá trị/trọng lượng giảm dần
        return Double.compare(other.getValuePerWeight(), this.getValuePerWeight());
    }
    
    @Override
    public String toString() {
        return String.format("Item{name='%s', weight=%.2f, value=%.2f, ratio=%.2f}", 
                name, weight, value, getValuePerWeight());
    }
}
