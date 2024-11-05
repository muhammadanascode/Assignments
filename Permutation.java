import java.util.ArrayList;

public class Permutation {

    // Generate and print permutations
    public static void possiblePermutations(ArrayList<String> arr, int r) {
        if (arr.isEmpty()) {
            System.out.println("Input list is empty, no permutations possible.");
            return;
        }

        if (r == 0) {
            System.out.println("[]");
        } else if (r == 1) {
            for (String s : arr) {
                System.out.println(s);
            }
        } else {
            generatePermutations(arr, r, new ArrayList<>(), new boolean[arr.size()]);
        }
    }

    // Helper method to generate permutations using backtracking
    private static void generatePermutations(ArrayList<String> arr, int r, ArrayList<String> current, boolean[] used) {
        if (current.size() == r) {
            System.out.println(current);  // Print as array
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(arr.get(i));
                generatePermutations(arr, r, current, used);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        possiblePermutations(arr, 2);
    }
}
