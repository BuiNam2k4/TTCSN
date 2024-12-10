/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thamlam;

/**
 *
 * @author Admin
 */
class SelectedItem {//Lưu tông tin món đồ đã chọn
    private Item item; //Món hàng
    private double weight;//Trọng lượng được chọn
    
    public SelectedItem(Item item, double weight){
        this.item = item;
        this.weight = weight;
    }
    public Item getItem(){
        return item;
    }
    public double getWeight(){
        return weight;
    }
    public double getValue(){
        return item.getValue() * (weight/item.getWeight());
    }
}
