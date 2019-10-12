package LeetCode.RemoveDuplicates;

/**
 * @author Ling
 * Created on 2019/10/12
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution {
    public static int removeDuplicates(int[] nums) {
        int k = 1;  // 非重复元素将要插入的位置
        int len = nums.length;
        if (len==0)
            return 0;
        int per = nums[0];
        for (int i = 1;i<len;i++){
            if (nums[i] != per){
                nums[k++] = nums[i];
                per = nums[i];
            }
        }
        return k;
    }


    // 更优雅的写法，不知为何空间用的更多了？
    public static int removeDuplicates2(int[] nums) {
        // 省略lenght为0
        int k = 0;  // 已经插入元素的位置
        for (int i = 1; i<nums.length;i++) {
            if (nums[i] != nums[k])
                nums[++k] = nums[i];
        }
        return k+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(nums)+"\n");
        for (int num : nums)
            System.out.println(num);
    }
}
