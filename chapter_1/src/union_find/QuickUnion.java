package union_find;

public class QuickUnion implements  UF {
    private  int count;

    private int[] id;

    public  QuickUnion(int N){
        this.count = N;
        id = new int[N];
        for(int i = 1; i <= count; i++){
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return ;
        }
        id[pRoot] = qRoot;
        count--;
    }

    @Override
    public int find(int p) {
        while(p != id[p]){
            p = id[p];
        }

        return p;
    }

    @Override
    public boolean connectde(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
