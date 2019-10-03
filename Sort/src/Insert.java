/**
 * @author Ling
 * Created on 2019/10/3
 */

/*
插入排序过程中，整个数组被视为已排序和未排序的部分。
1、将开头元素试为以哦艾许
2、取出未排序的开头
3、将已排序的所有大于未排序开头的元素后移一位
4、插入空位

主要变量：
    1、i，循环变量，用于表示未排序部分的开头
    2、v，临时保存A[i]的值
    3、循环变量，用于在已排序部分寻找插入位置

复杂度：
    这里需要估计每个i循环中A[j]元素向后移的次数，最坏的情况下，每个i循环都晕移动i次
  总共需要1+2+...+N-1次，即算法复杂度为0(n^2)，有趣的是，输入数据的顺序能大幅影响复杂度
  可见：插入排序算法的优势就在于能够快速处理相对有序的数据。
 */
public class Insert {
    public static void InsertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int v = nums[i];
            int j = i - 1;
            while (j>=0 && nums[j] > v) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = v;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,6,234,2,15,62,2};
        InsertSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
