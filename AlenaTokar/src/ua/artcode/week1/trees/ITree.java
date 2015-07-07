package trees;

/**
 * Created by tokar on 27.06.2015.
 */
public interface ITree<T> {
        boolean add(T obj);
        boolean remove(T obj);
        boolean contains(T obj);
        void print();

}
