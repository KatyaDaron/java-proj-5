// Time complexity of recursiveSearch is O(n) as it will perform a search through the array,
// making recursive calls for each element until the item is found or the end of the array is reached.

public class RecursiveSearch {
    public static int recursiveSearch(String item, String[] arr, int index) {
        if (index >= arr.length) {
            return -1;  // Item not found
        } else if (arr[index].equals(item)) {
            return index;  // Item found
        } else {
            return recursiveSearch(item, arr, index + 1);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"hey", "there", "you"};
        System.out.println(recursiveSearch("hey", arr, 0));  // Output: 0

        String[] arr2 = {"hey", "there", "you"};
        System.out.println(recursiveSearch("porcupine", arr2, 0));  // Output: -1
    }
}