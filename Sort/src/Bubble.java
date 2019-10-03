/**
 * @author Ling
 * Created on 2019/10/3
 */
public class Bubble {
    public static void bubbleSort(int[] nums) {
        boolean flag = true;
        int i = 0;
        while (flag) {
            flag = false;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    flag = true;
                }
            }
            i++;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {23, 41, 54, 7, 32, 8, 32, 1};
        bubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
