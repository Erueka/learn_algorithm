package LeetCode.MergeTwoSortedArray88;

public class Merge {
    // 要注意保持循环不变量
    // 这里的循环不变量为
    // ptr1 num1_copy中下一个待移出插入的元素的索引
    // ptr2 num2中下一个待移出插入num1的元素的索引
    // p num1中下一个将要被插入元素的空位
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num1_copy = new int[m];
        System.arraycopy(nums1,0,num1_copy,0,m);
        int ptr1 = 0;   // num1_copy的便利指针,将被判断，还没被插入
        int ptr2 = 0;   // num2的遍历指针
        int p = 0;      // 插入num1的位置

        while (ptr1<m && ptr2<n) {
            nums1[p++] = (num1_copy[ptr1]<=nums2[ptr2])? num1_copy[ptr1++] : nums2[ptr2++];
        }

        if (ptr1<m) {   // ptr2到头了
            System.arraycopy(num1_copy,ptr1,nums1,ptr1+ptr2,m-ptr1);
        }else {
            System.arraycopy(nums2,ptr2,nums1,ptr1+ptr2,n-ptr2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,0,0,0,0,0};
        int[] nums2 = {6,7,8,9,10};
        merge(nums1,5,nums2,5);

        for (int num : nums1)
            System.out.println(num);
    }
}
