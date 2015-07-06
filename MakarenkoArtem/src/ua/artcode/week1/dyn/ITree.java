package ua.artcode.week1.dyn;


public interface ITree<T> {

    boolean add(T obj);
    boolean remove(T obj);
    boolean contains(T obj);
    void print();

}
