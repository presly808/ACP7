package week1.myTreeSet;

/**
 * Created by Джек on 27.06.2015.
 */
public interface ITree <E> {

    boolean add(E obj);
    boolean delete(E obj);
    boolean contains(E obj);
    void print();
    E findMin();
    E findMax();

    void treeOptimization();
    void rotateRight();
    void rotateLeft();


}
