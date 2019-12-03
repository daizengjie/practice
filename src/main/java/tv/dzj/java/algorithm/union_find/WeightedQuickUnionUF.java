package tv.dzj.java.algorithm.union_find;

/**
 * 加权QuickUnion
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class WeightedQuickUnionUF extends UF{

    /**
     * 保存节点的数量信息
     */
    private int[] sz;

    public WeightedQuickUnionUF(int N){
        super(N);
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public void union(int p, int q) {

    }
}
