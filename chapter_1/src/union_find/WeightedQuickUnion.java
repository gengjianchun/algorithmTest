package union_find;

public class WeightedQuickUnion implements  UF {

    private  int count;

    private int[] id;

    private int[] size;

    public  WeightedQuickUnion(int N){
        this.count = N;
        for(int i = 1; i <= N; i++){
            id[i] = i;
            size[i] =1;
        }
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return ;
        }
        if(size[pRoot] > size[qRoot]){
            id[qRoot] = pRoot;
            size[pRoot] += size[pRoot];
        }else {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot]
        }
        count--;

    }

    public int find(int p) {
        while (p != id[p]){
            p = id[p]
        }
        return p;
    }

    public boolean connectde(int p, int q) {
        return false;
    }

    public int count() {
        return 0;
    }
}
