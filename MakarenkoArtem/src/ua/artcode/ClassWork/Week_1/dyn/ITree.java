package ua.artcode.ClassWork.Week_1.dyn;

import java.util.Collection;


public interface ITree<T> {

    boolean add(T obj);
    boolean remove(T obj);
    boolean contains(T obj);
    void print();

}
