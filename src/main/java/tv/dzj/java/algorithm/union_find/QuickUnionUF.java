package tv.dzj.java.algorithm.union_find;

/**
 * Quick Union
 * 快速进行 union 操作，只需要修改一个节点的 id 值即可
 * find 操作开销很大，因为同一个连通分量的节点 id 值不同，id 值只是用来指向另一个节点。
 * 因此需要一直向上查找操作，直到找到最上层的节点
 * @author dzj
 */
public class QuickUnionUF extends UF {

    public QuickUnionUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot != qRoot) {
            id[pRoot] = qRoot;
        }
    }
}
