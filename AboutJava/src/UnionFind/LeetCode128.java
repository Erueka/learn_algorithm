package UnionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ling
 * Created on 2019/10/28
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        // 初始化查并集，每个元素都是单独一类
        // 因为要查找某元素对应的集合是否存在，所以这里用哈希表作为并查集
        Map<Integer, Integer> uf = new HashMap<>();
        for (int num : nums)
            uf.put(num, num);    // 第二个表示parent

        // 并
        for (int num : nums) {
            if (uf.containsKey(num - 1))
                uf.put(num, num - 1);
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : uf.keySet()) {
            int root = find(uf, num);
            count.put(root,count.getOrDefault(root,0)+1);
        }

        int max = 1;
        for (int key : count.keySet()){
            int c = count.get(key);
            max = c > max ? c : max;
        }

        return max;
    }

    // 查
    private int find(Map<Integer, Integer> uf, int p) {
//        while (uf.get(p) != p) {
//            uf.put(p,uf.get(uf.get(p)));    // p.parent = p.parent.parent
//            p=uf.get(p);
//        }
//        return p;
        if (uf.get(p) != p) {
            uf.put(p, find(uf, uf.get(p)));   // p.parent = find(p.parent)
        }
        return uf.get(p);
    }
}
