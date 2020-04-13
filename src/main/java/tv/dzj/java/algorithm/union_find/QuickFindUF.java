package tv.dzj.java.algorithm.union_find;

/**
 * Quick Find
 * 保证同一连通分量的所有节点的 id 值相等
 * union 操作代价却很高，需要将其中一个连通分量中的所有节点 id 值都修改为另一个节点的 id 值
 * @author dzj
 */
public class QuickFindUF extends UF {

    public QuickFindUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID){
            return ;
        }

        for(int i = 0; i < id.length; i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
    }
}
