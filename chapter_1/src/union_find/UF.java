package union_find;

public interface UF {

    public  void  union(int p , int q);

    public int find (int p);

    public boolean connectde(int p , int q);

    public int count();
}
