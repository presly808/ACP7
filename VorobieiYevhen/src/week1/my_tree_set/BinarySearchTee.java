package week1.my_tree_set;

/**
 * Created by Джек on 27.06.2015.
 */
public class BinarySearchTee<E> implements ITree<E> {

    //TODO refactoring

    private Node root;
    private int size = 0;


    private static class Node <E> {
        private Object value;
        private Node leftChild;
        private Node rightChild;
        private Node parent;

        public Node() {}

        public Node(Object value, Node leftChild, Node rightChild, Node parent) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }

        public boolean equals(Object o) {

            if (this == o)
                return true;

            if (o == null)
                return false;

            if (getClass() != o.getClass())
                return false;

            Node<E> node  = (Node<E>) o;

            if (value != node.value)
                return false;


            return true;


        }
    }


    @Override
    public boolean add(E obj) {

        isComparable(obj);

        Comparable forCompare = (Comparable) obj;

        if (root == null) {
            root = new Node(obj, null, null, null);
            size++;
            return true;
        } else {
            Node iter = root;
            while (iter != null) {
                int compaRes = forCompare.compareTo(iter.value);
                if (compaRes < 0) {
                    if (iter.leftChild == null) {
                        iter.leftChild = new Node(obj, null, null, iter);
                        size++;
                        return true;
                    } else {
                        iter = iter.leftChild;
                    }
                } else if (compaRes > 0) {
                    if (iter.rightChild == null) {
                        iter.rightChild = new Node(obj, null, null, iter);
                        size++;
                        return true;
                    } else {
                        iter = iter.rightChild;
                    }
                } else {
                    iter.value = obj;
                    return  false;
                }
            }
        }
        return false;
    }

    private void isComparable(E obj) {
        if (!(obj instanceof Comparable)) {
            throw new NotComparableExeption(obj.getClass().getName() + " doesn't implement Comparable");

        }
    }

    @Override
    public boolean delete (E obj) {
        isComparable(obj);
        Node remove = binarySearch(obj);

        if (remove != null && remove != root) {

            if (remove.rightChild == null && remove.leftChild == null) {
                    if (remove.parent.leftChild != null && remove.parent.leftChild.equals(remove)) {
                        remove.parent.leftChild = null;
                    } else {
                        remove.parent.rightChild = null;
                    }
            }
            else if (remove.rightChild == null && remove.leftChild != null) {
                    if (remove.parent.leftChild != null && remove.parent.leftChild.equals(remove)) {
                        remove.parent.leftChild = remove.leftChild;
                    } else {
                        remove.parent.rightChild = remove.leftChild;
                    }
            } else if (remove.rightChild != null && remove.leftChild == null) {
                    if (remove.parent.rightChild != null && remove.parent.rightChild.equals(remove)) {
                        remove.parent.rightChild = remove.rightChild;
                    } else {
                        remove.parent.leftChild = remove.rightChild;
                    }
            } else if (remove.rightChild != null && remove.leftChild != null) {
                    if (remove.rightChild.leftChild == null) {
                        remove.rightChild.leftChild = remove.leftChild;
                    } else {
                        goLeft(remove).leftChild = remove.leftChild;
                    }
                    if (remove.parent.rightChild != null && remove.parent.rightChild.equals(remove)) {
                        remove.parent.rightChild = remove.rightChild;
                    }else {
                        remove.parent.leftChild = remove.rightChild;
                    }
            }
            size--;
            return true;
        } else if (remove != null && remove == root) {
            if (remove.rightChild.leftChild == null) {
                remove.rightChild.leftChild = remove.leftChild;
            } else {
                goLeft(remove).leftChild = remove.leftChild;
            }
            root = remove.rightChild;
            size--;
            return true;
        }

        return false;
    }

    @Override
    public boolean contains(E obj) {

        isComparable(obj);

        return  binarySearch(obj) != null;


    }

    private Node binarySearch(E obj) {



        Comparable forCompare = (Comparable) obj;

        Node iter = root;

        while (iter != null) {
            int branch = forCompare.compareTo(iter.value);
            if (branch < 0) {
                iter = iter.leftChild;
            } else if (branch > 0) {
                iter = iter.rightChild;
            } else {
                return iter;
            }
        }

        return null;
    }

    @Override
    public void print() {
        traverse(root);
    }

    @Override
    public E findMin() {
        return (E)(goLeft(root).value);
    }

    private Node<E> goLeft (Node<E> node) {

        if (node == null) {
        return node;
        }

        while (node.leftChild != null) {
            node = node.leftChild;
            goLeft(node);
                    }
        return node;
    }

    @Override
    public E findMax() {
        return (E)(goRight(root).value);
    }

    private Node<E> goRight (Node<E> node) {

        if (node == null) {
            return node;
        }

        while (node.rightChild != null) {
            node = node.rightChild;
            goRight(node);
        }
        return node;
    }

    public  void traverse (Node<E> node) {

        if (node == null) {
            return;
        }

        traverse(node.leftChild);
        System.out.println(node.value);
        traverse(node.rightChild);

    }

    public int size() {
        return size;
    }
}
