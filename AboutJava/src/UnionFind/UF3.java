package UnionFind;

/**
 * @author Ling
 * Created on 2019/10/28
 */
public class UF3 {
    // rank[i] 表示层数
    private int[] parent,rank;
    private int length;

    public UF3(int n) {
        parent = new int[n];
        rank = new int[n];
        length = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // 返回p对应的组
    public int find(int p) {
        if (p < 0 || p >= length)
            return -1;
//        while (parent[p] != p) {    // 路径压缩优化
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }
//
//        return p;

        if (p!=parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot==qRoot)
            return;

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        }else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }else {
            parent[pRoot] = qRoot;
            rank[qRoot]++;
        }
    }
}

