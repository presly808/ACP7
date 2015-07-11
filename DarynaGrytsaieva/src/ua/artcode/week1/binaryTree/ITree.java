package ua.artcode.week1.binaryTree;

/**
 * Created by Daryna on 27-Jun-15.
 *
 * Implement BinarySearchTree
 methods
 1) add
 2) traverse
 3) findMin
 4) findMax
 5) remove

 tree optimization
 6) rotate right
 7) rotate left
 8) implement iterator
 */
public interface ITree<T> {
    boolean add(T obj);
    boolean remove(T obj);
    boolean contains(T obj);
    T findMin();
    T findMax();

    void traversalPrint();
    boolean rightRotate(T obj);
    boolean leftRotate(T obj);

}

