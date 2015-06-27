package ua.artcode.ds.dyn;

public class BinarySearchTree implements ITree {

    private TreeNode root; // null
    private int size;


    @Override
    public boolean add(Object obj) { // SOLID, DI principle

        if(!(obj instanceof Comparable)){
            throw new NotComparableException(obj.getClass().getName() + " doesn't implement Comparable");
        }
        Comparable forCompare = (Comparable) obj;


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

        if(curr == null){
            return curr;
        }

        int compareRes = forCompare.compareTo(curr.value);

        TreeNode next = compareRes < 0 ?
                curr.lChild : (compareRes > 0 ?
                                    curr.rChild : null);


        return findFreePlaceRec(next, forCompare);


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
    public boolean remove(Object obj) {
        return false;
    }

    @Override
    public boolean contains(Object obj) {
        return false;
    }

    @Override
    public void print() {

    }


    // inner or nested
    private class TreeNode {
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
