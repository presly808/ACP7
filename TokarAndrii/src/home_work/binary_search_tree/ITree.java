package home_work.binary_search_tree;

public interface ITree<T> {


    boolean add(T obj);

    boolean remove(T obj);

    boolean contains(T obj);

    void print();
}
