package week1.my_tree_set;

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
        private int balance = 0;

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

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

                        //iter.setBalance(iter.getBalance() + 1);

                        iter = iter.getLeftChild();

                        do {

                            int child;
                            if (iter == iter.getParent().getRightChild()) {
                                child = (-1);
                            } else {
                                child = 1;
                            }

                            iter.getParent().setBalance(iter.getParent().getBalance() + (child * 1));

                            if (iter.getParent().getBalance() == (-2)) {
                                Node tmp = rotateLeft(iter);
                                if (iter.getParent() != null) {
                                    tmp.setParent(iter.getParent());
                                    iter.getParent().setRightChild(tmp);
                                } else {
                                    root = tmp;
                                }



                            } else if ( iter.getParent().getBalance()  == 2) {

                                Node tmp = rotateRight(iter);
                                if (iter.getParent() != null) {
                                    tmp.setParent(iter.getParent());
                                    iter.getParent().setLeftChild(tmp);
                                } else {
                                    root = tmp;
                                }
                            }

                            iter = iter.getParent();

                        }while (iter != null && iter.getParent() != null);


                        return true;
                    } else {
                        iter = iter.leftChild;
                    }
                } else if (compaRes > 0) {
                    if (iter.rightChild == null) {
                        iter.rightChild = new Node(obj, null, null, iter);
                        size++;
                        //iter.setBalance(iter.getBalance() -1);

                        iter = iter.getRightChild();

                         do {

                            int child;
                            if (iter == iter.getParent().getRightChild()) {
                                child = (-1);
                            } else {
                                child = 1;
                            }

                             iter.getParent().setBalance(iter.getParent().getBalance() + (child * 1));

                            if (iter.getParent().getBalance() == (-2)) {
                                Node tmp = rotateLeft(iter);
                                if (iter.getParent() != null) {
                                    tmp.setParent(iter.getParent());
                                    iter.getParent().setRightChild(tmp);
                                } else {
                                    root = tmp;
                                }



                            } else if ( iter.getParent().getBalance()  == 2) {

                                Node tmp = rotateRight(iter.getParent());
                                if (iter.getParent() != null) {
                                    tmp.setParent(iter.getParent());
                                    iter.getParent().setLeftChild(tmp);
                                } else {
                                    root = tmp;
                                }
                            }

                            iter = iter.getParent();

                        }while (iter != null && iter.getParent() != null);

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
        traverse(root);
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
            goRight(node);
        }
        return node;
    }

    @Override
    public void treeOptimization() {


    }


    public Node rotateRight(Node node) {

        Node tmp = node.getParent();

        node.setParent(node.getParent().getParent());
        tmp.setLeftChild(node.getRightChild());
        node.setRightChild(tmp);
        node.setBalance(node.getBalance() - 1);
        node.getRightChild().setBalance(node.getRightChild().getBalance() - 1);

        return node;
    }


    public Node rotateLeft(Node node) {

        Node tmp = node.getParent();

        node.setParent(node.getParent().getParent());
        tmp.setRightChild(node.getLeftChild());
        node.setLeftChild(tmp);
        node.setBalance(node.getBalance() + 1);
        node.getLeftChild().setBalance(node.getLeftChild().getBalance() + 1);

        return node;
    }

    public  void traverse (Node node) {

        if (node == null) {
            return;
        }

        traverse(node.getLeftChild());
        System.out.println(node.getObj());
        traverse(node.getRightChild());

    }

    public int size() {
        return size;
    }
}
