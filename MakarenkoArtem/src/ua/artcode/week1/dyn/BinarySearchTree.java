package ua.artcode.week1.dyn;

import ua.artcode.ds.dyn.ITree;
import ua.artcode.ds.dyn.NotComparableException;

public class BinarySearchTree<E> implements ITree<E> {

    private TreeNode root; // null
    private int size;


    @Override
    public boolean add(E obj) { // SOLID, DI principle

        Comparable forCompare = checkAndCast(obj);


        if(root == null){
            root = new TreeNode(null, obj, null, null);
            size++;
            return true;
        } else {
            // upcastiong Object o = new Man();
            // ClassCastException, down casting (Comparable) o
            TreeNode parent = findFreePlaceRec(root, forCompare);
            if(parent == null){
                return false;// when unique elements
            }

            TreeNode child = new TreeNode(parent, obj, null, null);
            return linkChildWithParent(parent, child, forCompare.compareTo(parent.value) > 0);

        }

    }

    private Comparable checkAndCast(Object obj){
        if(!(obj instanceof Comparable)){
            throw new NotComparableException(obj.getClass().getName() + " doesn't implement Comparable");
        }
        return (Comparable) obj;
    }

    private TreeNode findFreePlace(TreeNode curr, Comparable forCompare){
        while(curr != null){
            int compareRes = forCompare.compareTo(curr.value);

            if(compareRes < 0){
                if(curr.lChild == null){
                    return curr;
                } else {
                    curr = curr.lChild; // iteration, find free place
                }
            } else  if (compareRes > 0){
                if(curr.rChild == null){
                    return curr;
                } else {
                    curr = curr.rChild; //iteration, find free place
                }
            }

        }

        return null;

    }

    private TreeNode findFreePlaceRec(TreeNode curr, Comparable forCompare){

        int compareRes = forCompare.compareTo(curr.value);

        TreeNode next = compareRes < 0 ? curr.lChild
                : (compareRes > 0 ? curr.rChild : null);



        return next == null ? curr : findFreePlaceRec(next, forCompare);

    }

    private boolean linkChildWithParent(TreeNode parent, TreeNode child, boolean right){
        if(right){
            parent.rChild = child;
        } else {
            parent.lChild = child;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(E obj) {
        Comparable forCompare = checkAndCast(obj);

        return false;
    }

    @Override
    public boolean contains(E obj) {
        return findNode(root,checkAndCast(obj)) != null;
    }

    private TreeNode findNode(TreeNode curr, Comparable forCompare){
        if(curr == null){
            return null;
        }

        int compareRes = forCompare.compareTo(curr.value);

        return compareRes < 0 ? findNode(curr.lChild, forCompare) :
                (compareRes > 0 ? findNode(curr.rChild, forCompare) : curr);
    }

    @Override
    public void print() {
        System.out.println(iterate(root));
    }

    private String iterate(TreeNode curr){
        if(curr == null){
            return "";
        }

        String res = "";

        res += iterate(curr.lChild);
        res += curr.value.toString() + "-";
        res += iterate(curr.rChild);

        return res;
    }



    // inner or nested
    private static class TreeNode {
        TreeNode parent;
        Object value;
        TreeNode lChild;
        TreeNode rChild;

        public TreeNode(TreeNode parent, Object value,
                        TreeNode lChild, TreeNode rChild) {
            this.parent = parent;
            this.value = value;
            this.lChild = lChild;
            this.rChild = rChild;
        }

        public TreeNode() {
        }
    }
}
