import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//    Write a function that takes this list of numbers, as well as the max_num, and it should return the missing number.
//
//    For example, given a list of numbers, in random order, of 1…10, 8 was removed. If this list and the maxNum of 10 was passed into the function, it would return 8: missingNumber({2, 1, 4, 3, 6, 5, 7, 10, 9}, 10) ⇒ 8
//
//    If there is no missing number, the function should return 0.

public class MissingNumber {
    ///////////////////SOLUTION 1///////////////////
    public static int missingNumber(int[] nums, int maxNum) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= maxNum; i += 1) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    ///////////////////SOLUTION 2///////////////////
    public static int missingNumberSort(int[] nums, int maxNum) {
        Arrays.sort(nums);

        for (int i = 1; i < maxNum; i += 1) {
            if (i != nums[i - 1]) {
                return i;
            }
        }

        // If none is missing
        if (nums.length == maxNum && nums[maxNum - 1] == maxNum) {
            return 0;
        }

        return maxNum;
    }

    ///////////////////SOLUTION 3///////////////////
    public static int missingNumberSum(int[] nums, int maxNum) {
        // Alternate solution: int sum = (nums.length + 1)*(nums.length) / 2
        int expectedSum = 0;
        for (int i = 1; i <= maxNum; i += 1) {
            expectedSum += i;
        }

        int actualSum = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{2, 1, 4, 3, 6, 5, 7, 10, 9}, 10));
        System.out.println(missingNumberSort(new int[]{2, 1, 4, 3, 6, 5, 7, 10, 9}, 10));
        System.out.println(missingNumberSum(new int[]{2, 1, 4, 3, 6, 5, 7, 10, 9}, 10));
    }
}
