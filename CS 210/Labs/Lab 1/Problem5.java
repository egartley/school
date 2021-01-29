import java.util.Arrays;

public class Problem5 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(nums));
        System.out.println("Sum: " + getSum(nums));
        System.out.println("Average: " + getAverage(nums));
        System.out.println("Max: " + getMax(nums));
        System.out.println("Min: " + getMin(nums));
    }

    public static int getSum(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static int getAverage(int[] nums) {
        return getSum(nums) / nums.length;
    }

    public static int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int getMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }

}
