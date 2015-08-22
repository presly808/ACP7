package ua.artcode.week1.binary_tree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Daryna on 27-Jun-15.
 */
public class BinarySearchTree<E> implements ITree<E>, Iterable<E> {

    private TreeNode root; // null
    private int size;

    private Comparable checkAndCast(Object obj) {
        if (!(obj instanceof Comparable)) {
            throw new NotComparableException(obj.getClass().getName() + " doesn't implement Comparable");
        }
        return (Comparable) obj;
    }

    @Override
    public boolean add(E obj) { // SOLID, DI principle

        /*if (!(obj instanceof Comparable)) {
            throw new NotComparableException(obj.getClass().getName() + " doesn't implement Comparable");
        }
        Comparable forCompare = (Comparable) obj;
        */
        Comparable forCompare = checkAndCast(obj);


        if (root == null) {
            root = new TreeNode(null, obj, null, null);
            size++;
            return true;
        } else {
            // upcastiong Object o = new Man();
            // ClassCastException, down casting (Comparable) o
            TreeNode parent = findFreePlace(root, forCompare);
            if (parent == null) {

                return false;// when unique elements
            }

            TreeNode child = new TreeNode(parent, obj, null, null);
            size++;
            return linkChildWithParent(parent, child, forCompare.compareTo(parent.value) > 0);

        }

    }

    private TreeNode findFreePlace(TreeNode curr, Comparable forCompare) {
        while (curr != null) {
            int compareRes = forCompare.compareTo(curr.value);

            if (compareRes < 0) {
                if (curr.lChild == null) {
                    return curr;
                } else {
                    curr = curr.lChild; // iteration, find free place
                }
            } else if (compareRes > 0) {
                if (curr.rChild == null) {
                    return curr;
                } else {
                    curr = curr.rChild; //iteration, find free place
                }
            }

        }

        return null;

    }

    private TreeNode findFreePlaceRec(TreeNode curr, Comparable forCompare) {

        if (curr.value == null) {
            return curr;
        }

        int compareRes = forCompare.compareTo(curr.value);

        TreeNode next = compareRes < 0 ?
                curr.lChild : (compareRes > 0 ?
                curr.rChild : null);


        return next == null ? curr : findFreePlaceRec(next, forCompare);


    }

    private boolean linkChildWithParent(TreeNode parent, TreeNode child, boolean right) {
        if (right) {
            parent.rChild = child;
            child.parent = parent;

        } else {
            parent.lChild = child;
            child.parent = parent;
        }

        return true;
    }


    @Override
    public boolean remove(E obj) {

        Comparable forCompare = checkAndCast(obj);
        if (!this.contains(obj)) {
            return false;
        }
        size--;
        return remove(root, forCompare);

    }

    private boolean remove(TreeNode curr, Comparable forCompare) {
        if (curr == null) {
            return false;
        }

        TreeNode elementToRemove = findNodeByValue(root, forCompare);
        boolean hasParent = elementToRemove.parent != null;
        boolean isLeft = hasParent && (forCompare.compareTo(elementToRemove.parent.value) < 0);

        // element is leaf
        if (elementToRemove.rChild == null && elementToRemove.lChild == null) {
            if (hasParent) {
                //element is left leaf
                if (isLeft) {
                    elementToRemove.parent.lChild = null;
                } else {
                    //element is right leaf
                    elementToRemove.parent.rChild = null;
                }
            }
            //element has no rChild but has lChild
        } else if (elementToRemove.rChild == null && elementToRemove.lChild != null) {
            if (hasParent) {
                if (isLeft) {
                    return linkChildWithParent(elementToRemove.parent, elementToRemove.lChild, false);
                } else {
                    return linkChildWithParent(elementToRemove.parent, elementToRemove.lChild, true);
                }
                //element is root
            } else {
                root = elementToRemove.lChild;
                return true;
                //elementToRemove.lChild.parent = null; // -?

            }
            //element has no lChild but has  rChild
        } else if (elementToRemove.rChild != null && elementToRemove.lChild == null) {
            if (hasParent) {
                if (isLeft) {
                    return linkChildWithParent(elementToRemove.parent, elementToRemove.rChild, false);
                } else {
                    return linkChildWithParent(elementToRemove.parent, elementToRemove.rChild, true);
                }
                //element is root and has rChild
            } else {
                root = elementToRemove.rChild;
                //elementToRemove.rChild.parent=null; //-?
            }
            //element has both rChild and lChild
        } else if (elementToRemove.rChild != null && elementToRemove.lChild != null) {
            if (hasParent) {

                TreeNode rightMin = findMin(elementToRemove.rChild);
                remove((E) rightMin.value);
                size++;
                elementToRemove.value = rightMin.value;


            } else { //element is root
                TreeNode rightMin = findMin(root.rChild);
                remove((E) rightMin.value);
                size++;
                root.value = rightMin.value;


            }
        }
        //Find min of right tree and make it root value instead of deleted element

        return true;

    }

    //unnecessary method -?
    public TreeNode findNodeByValue(E obj) {
        Comparable forCompare = checkAndCast(obj);
        return findNodeByValue(root, forCompare);

    }

    private TreeNode findNodeByValue(TreeNode curr, Comparable forCompare) {
        if (curr == null) {
            return null;
        }
        if (forCompare.compareTo(curr.value) == 0) {
            return curr;
        }
        if (forCompare.compareTo(curr.value) > 0) {
            return findNodeByValue(curr.rChild, forCompare);
        } else {
            return findNodeByValue(curr.lChild, forCompare);
        }

    }

    @Override
    public boolean contains(E obj) {
        if (!(obj instanceof Comparable)) {
            throw new NotComparableException(obj.getClass().getName() + " doesn't implement Comparable");
        }
        Comparable forCompare = (Comparable) obj;

        // or Comparable forCompare= checkAndCast(obj);

        return contains(root, forCompare);
    }

    private boolean contains(TreeNode curr, Comparable forCompare) {

        if (curr == null) {
            return false;
        }
        if (forCompare.compareTo(curr.value) == 0) {
            return true;
        }
        if (forCompare.compareTo(curr.value) > 0) {
            return contains(curr.rChild, forCompare);
        } else {
            return contains(curr.lChild, forCompare);
        }


    }


    @Override
    public E findMin() {
        if (root == null) {
            return null;
        }
        return (E) (findMin(root).value);

    }

    private TreeNode findMin(TreeNode curr) {
        while (curr.lChild != null) {
            curr = curr.lChild;
        }
        return curr;
    }


    @Override
    public E findMax() {
        if (root == null) {
            return null;
        }
        return (E) findMax(root).value;
    }

    private TreeNode findMax(TreeNode curr) {
        while (curr.rChild != null) {
            curr = curr.rChild;
        }
        return curr;
    }


    @Override
    public boolean rightRotate(E obj) {

        if (!contains(obj)) {
            return false;
        }
        TreeNode turnRoot = findNodeByValue(obj);
        if (turnRoot.lChild == null) {
            System.out.println("Can't rotate.");
            return false;
        }
        TreeNode turnPivot = turnRoot.lChild;
        if (turnRoot.parent == null) {
            root = turnPivot;
            turnPivot.parent = null;
        } else {
            linkChildWithParent(turnRoot.parent, turnPivot, false);

        }


        if (turnPivot.rChild == null) {
            turnRoot.lChild = null;
        } else {
            linkChildWithParent(turnRoot, turnPivot.rChild, false);
        }
        linkChildWithParent(turnPivot, turnRoot, true);
        return true;
    }

    @Override
    public boolean leftRotate(E obj) {


        if (!contains(obj)) {
            return false;
        }
        TreeNode turnRoot = findNodeByValue(obj);
        if (turnRoot.rChild == null) {
            System.out.println("Can't rotate.");
            return false;
        }
        TreeNode turnPivot = turnRoot.rChild;
        if (turnRoot.parent == null) {
            root = turnPivot;
            turnPivot.parent = null;
        } else {
            linkChildWithParent(turnRoot.parent, turnPivot, true);
        }


        if (turnPivot.lChild == null) {
            turnRoot.rChild = null;
        } else {
            linkChildWithParent(turnRoot, turnPivot.lChild, true);
        }
        linkChildWithParent(turnPivot, turnRoot, false);
        return true;
    }

    @Override
    public void traversalPrint() {
        traversalPrint(root);
        System.out.println();

    }

    private void traversalPrint(TreeNode curr) {

        if (curr == null) {
            return;
        }
        traversalPrint(curr.lChild);
        System.out.print(curr.value + " ");
        traversalPrint(curr.rChild);
    }


    public int getSize() {
        return size;
    }


    // inner or nested
    private class TreeNode<E> {
        TreeNode parent;
        E value;
        TreeNode lChild;
        TreeNode rChild;

        public TreeNode(TreeNode parent, E value,
                        TreeNode lChild, TreeNode rChild) {
            this.parent = parent;
            this.value = value;
            this.lChild = lChild;
            this.rChild = rChild;
        }

        public TreeNode(E value) {
            this.value = value;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new BinarySearchTreeIterator();
    }

    public class BinarySearchTreeIterator implements Iterator<E> {
        Stack<TreeNode> stack;

        public BinarySearchTreeIterator() {
            stack = new Stack<TreeNode>();
            TreeNode curr = root;
            while (curr != null) {

                stack.push(curr);
                curr = curr.lChild;
            }

        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public E next() {
            TreeNode curr = stack.pop();
            E next = (E) curr.value;
            if (curr.rChild != null) {
                curr = curr.rChild;
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.lChild;
                }

            }

            return next;
        }
    }
}
