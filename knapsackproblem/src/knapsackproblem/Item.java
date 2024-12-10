package knapsackproblem;

public class Item {
	private String name;  // Tên vật phẩm
	private int weight;  //Trọng lượng vật phẩm
	private int value;  // Giá trị vật phẩm
	public Item() {
		
	}
	public Item(String name, int weight, int value) {
		this.weight = weight;
		this.value = value;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Item [weight=" + weight + ", value=" + value + ", name=" + name + "]";
	}
}
