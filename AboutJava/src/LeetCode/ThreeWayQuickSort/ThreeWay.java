package LeetCode.ThreeWayQuickSort;

/**
 * @author Ling
 * Created on 2019/10/13
 */
public class ThreeWay {
    public static void sort(int[] nums) {
        int len = nums.length;
        threeWayQuickSort(nums, 0, len - 1);
    }

    private static void threeWayQuickSort(int[] nums, int l, int r) {
        if (r - l <= 15) {
            insertSort(nums, l, r);
            return;
        }
        int v = nums[l];
        int left = l;       // [l+1,left] < v
        int right = r + 1;   // [right,r] > v
        int i = left + 1;       // [left+1,i) == v

        while (i < right) {
            if (nums[i] == v)
                i++;
            else if (nums[i] > v) {
                swap(nums, i, right - 1);
                right--;
            } else {
                swap(nums, i++, left + 1);
                left++;
            }
        }
        swap(nums, l, left);

        threeWayQuickSort(nums, l, left - 1);
        threeWayQuickSort(nums, right, r);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void insertSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) { // 第 1 遍不用插入，所以是总长度减去 1
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= left; j--) {
                if (arr[j] > temp) { // 后移一位
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    // Leetcode 75
    public void sortColors(int[] nums) {
        int zero = -1;  // [0,zero]==0
        int two = nums.length;        // [two,len-1]==2;
        int i = zero + 1;   // [zero+1,i)==1
        while (i < two) {
            if (nums[i]==2){
                swap(nums,i,two-1);
                two--;
            }else if (nums[i] == 0){
                swap(nums,i++,zero+1);
                zero++;
            }else {
                i++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 2, 2, 5, 8, 23, 1, 3, 4};
        sort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
