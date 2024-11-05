import java.util.ArrayList;

public class Combination {

    // Generate and print combinations
    public static void possibleCombinations(ArrayList<String> arr, int r) {
        if (arr.isEmpty()) {
            System.out.println("Input list is empty, no combinations possible.");
            return;
        }

        if (r == 0) {
            System.out.println("[]");
        } else {
            generateCombinations(arr, r, 0, new ArrayList<>());
        }
    }

    // Helper method to generate combinations using backtracking
    private static void generateCombinations(ArrayList<String> arr, int r, int start, ArrayList<String> current) {
        if (current.size() == r) {
            System.out.println(current);
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            current.add(arr.get(i));
            generateCombinations(arr, r, i + 1, current); // Move to the next element
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        possibleCombinations(arr, 2);
    }
}
