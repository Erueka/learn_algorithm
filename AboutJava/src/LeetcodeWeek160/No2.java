package LeetcodeWeek160;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ling
 * Created on 2019/10/27
 */
public class No2 {
    // LeetCode 5239
    // 格雷码生成+旋转数组
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        int max = ~(-1<<n)+1;
        for (int j =0;j<2;j++) {
            for (int i = 0; i < max; i++) {
                int greyCode = i ^ (i >> 1);
                list.add(greyCode);
            }
        }
        int startIndex = list.indexOf(start);
        return list.subList(startIndex,max+startIndex);
    }

/*    public List<String> grey(int bit) {
        List<String> ans = new ArrayList<>();
        for (int i = 0;i<Math.pow(2,bit);i++){
            int greyCode = (i>>1) ^ i;
            ans.add(Integer.toBinaryString(greyCode));
        }
        return ans;
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k<=1)   return;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }*/

    public static void main(String[] args) {
        No2 n = new No2();
        List<Integer> li = n.circularPermutation(2,3);
        for (int i : li)
            System.out.println(i);
    }
}
