package knapsackproblem;

public class KnapsackApp {

	public static void main(String[] args) {
		try {
            KnapsackSolver solver = new KnapsackSolver();
            solver.inputData();// Nhập dữ liệu
            solver.solveKnapsack();// Giải bài toán
        } catch (KnapsackException e) {
            System.err.println("Loi: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Đa xay ra loi ngoai y muon: " + e.getMessage());
        }
	}
}
