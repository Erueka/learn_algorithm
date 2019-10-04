import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shell {
    static long count = 0;


    private static void insertionSort(int[] nums, int gap) {
        int len = nums.length;
        for (int i = gap; i < len; i++){
            int v =nums[i];
            int j = i -gap;
            while (j >= 0 && nums[j]>v) {
                nums[j+gap] = nums[j];
                j-=gap;
                count++;
            }
            nums[j+gap] = v;
        }
    }

    public static void shellSort(int[] nums) {
        int len = nums.length;
        // 生成数列{1，4，13，40，121，364.....}
        List<Integer> gaps = new ArrayList<>();
        int gap = 1;
        while (gap<=len){
            gaps.add(gap);
            gap=3*gap+1;
        }
        Collections.reverse(gaps);

        for (int g : gaps){
            insertionSort(nums,g);
        }
    }

    public static void main(String[] args) {
        int[] nums = {23,53,221,65,23,1,54,7,53,2,12};
        shellSort(nums);
        System.out.println("希尔排序发生了"+count+"次数据交换。\n");
        for (int num : nums)
            System.out.println(num);
    }
}