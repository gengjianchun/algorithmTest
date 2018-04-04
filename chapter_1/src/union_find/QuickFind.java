package union_find;

public class QuickFind implements UF {

    private  int count;

    public  int[] id;

    public  QuickFind(int N){
        this.count = N;
        id = new int[N];
        for(int i = 1; i <= N; i++){
            id[i] = i;
        }
    }
    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];
        if(pId == qId){
            return;
        }
        for(int i = 1; i <id.length; i++){
            if(id[i] == pId){
                id[i] = qId;
            }
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connectde(int p, int q) {

        return id[p] == id[q];
    }

    @Override
    public int count() {
        return count;
    }
}
