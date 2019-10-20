package LeetCode.PriorityQueue;

import java.util.*;

/**
 * @author Ling
 * Created on 2019/10/20
 */
public class TopK {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // 统计出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num,0)+1);
        // 维护一个大小为K的小顶堆
        // 保存的是元素，比较的是元素的出现频率
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        // 存入k个元素，则堆顶是第K高频的元素
        // 往后，如果元素比堆顶大，则移除堆顶，新元素入堆
        for (int key : map.keySet()){
            if (heap.size()<k)
                heap.add(key);
            else if (map.get(key) > map.get(heap.peek())){
                heap.remove();
                heap.add(key);
            }
        }

        // 输出
        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty())
            res.add(heap.remove());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,54,4,3,31,11,1,1,1};
        System.out.println(topKFrequent(nums,3));
    }
}
