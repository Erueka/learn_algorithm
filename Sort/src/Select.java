public class Select {
    public static void selectSort(int[] nums) {
        // 选择未排序部分的最小值于未排序部分的起始元素交换

        /*
        主要变量：
        1、i:表示未排序的部分的开头，从开头向末尾移动
        2、min：表示为排序部分最小元素的下标
        3、j：用于循环查找最小元素


         */
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i;j<len;j++) {
                if (nums[j]<nums[min])
                    min = j;
            }
            swap(nums,min,i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {23,53,221,65,23,1,54,7,53,2,12};
        selectSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}