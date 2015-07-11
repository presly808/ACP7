package week1.myTreeSet;

/**
 * Created by Джек on 27.06.2015.
 */
public class BinarySearchTee<E> implements ITree<E> {
    private Node root;
    private int size = 0;


    private class Node {
        private Object value;
        private Node leftChild;
        private Node rightChild;
        private Node parent;

        public Object getObj() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public Node getParent() {
            return parent;
        }

        public Node() {
        }

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

            Node node  = (Node) o;

            if (value != node.value)
                return false;


            return true;


        }
    }


    @Override
    public boolean add(Object obj) {

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

    private void isComparable(Object obj) {
        if (!(obj instanceof Comparable)) {
            throw new NotComparableExeption(obj.getClass().getName() + " doesn't implement Comparable");

        }
    }

        @Override
    public boolean delete (Object obj) {
        return false;
    }

    @Override
    public boolean contains(Object obj) {

        isComparable(obj);

        if (root == null) {
            return  false;
        }

        Comparable forCompare = (Comparable) obj;
        Node iter = root;

        while (iter != null) {
            int branch = forCompare.compareTo(iter.value);
            if (branch < 0) {
                iter = iter.getLeftChild();
            } else if (branch > 0) {
                iter = iter.getRightChild();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public void print() {
        iterator(root);
    }

    @Override
    public E findMin() {


        return (E)(goLeft(root).value);
    }

    private Node goLeft (Node node) {

        if (node == null) {
        return node;
        }

        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
            goLeft(node);
                    }
        return node;
    }

    @Override
    public E findMax() {
        return (E)(goRight(root).value);
    }

    private Node goRight (Node node) {

        if (node == null) {
            return node;
        }

        while (node.getRightChild() != null) {
            node = node.getRightChild();
            goLeft(node);
        }
        return node;
    }

    @Override
    public void treeOptimization() {

    }

    @Override
    public void rotateRight() {

    }

    @Override
    public void rotateLeft() {

    }

    private  void iterator (Node node) {

        if (node == null) {
            return;
        }

        iterator(node.getLeftChild());
        System.out.println(node.getObj());
        iterator(node.getRightChild());

    }

    public int size() {
        return size;
    }
}
