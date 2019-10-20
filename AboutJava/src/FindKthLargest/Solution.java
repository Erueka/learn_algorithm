package FindKthLargest;

import java.util.Arrays;

/**
 * @author Ling
 * Created on 2019/10/9
 */
public class Solution {
    /*
    最直接的方法，时间复杂度为o(NlogN)
     */
    public static int findKthLarget1(int[] arr, int k) {
        int len = arr.length;
        Arrays.sort(arr);
        return arr[len - k];
    }

    /*
    利用快速排序的partition分治
     */
    public static int findKthLarget2(int[] arr, int k) {
        int len = arr.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int pos = partition(arr,left,right);
            if (pos == target)
                return arr[pos];
            if (pos > target)
                right = pos - 1;
            else
                left = pos + 1;
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int left = l;
        int right = r;
        int base = arr[left];
        while (left<right) {
            while (arr[left]<=base && left<right) left++;
            while (arr[right]>=base && left<right)    right--;
            swap(arr,left,right);
        }
        swap(arr,l,left);
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,2,5,5};
        System.out.println(findKthLarget2(arr,3));
    }
}
