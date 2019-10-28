package UnionFind;


/**
 * @author Ling
 * Created on 2019/10/28
 */
public class UF2 {
    // size[i]表示逸i为根的元素个数
    private int[] parent,size;
    private int length;

    public UF2(int n) {
        parent = new int[n];
        size = new int[n];
        length = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 返回p对应的组
    public int find(int p) {
        if (p < 0 || p >= length)
            return -1;
        while (parent[p] != p)
            p = parent[p];

        return p;
    }

    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot==qRoot)
            return;

        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}
