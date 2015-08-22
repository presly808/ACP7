package home_work.binary_search_tree;

public class BinarySearchTree<T> implements ITree<T> {

    private TreeNode root; // null
    private int size;

    private Comparable checkingComparableObj(T obj) {
        if (!(obj instanceof Comparable)) {
            throw new NotComparableException(obj.getClass().getName() + " doesn't implement Comparable");
        }
        Comparable forCompare = (Comparable) obj;

        return forCompare;

    }

    private TreeNode findMax(TreeNode<T> curr) {

        //int compareRes = forCompare.compareTo(curr.value);

        if (curr.rChild != null) {
            curr = curr.rChild;
            return findMax(curr);
            // return curr;
        } else {
            return curr;
        }


    }


    private TreeNode findNode(TreeNode<T> curr, Comparable<T> forCompare) {
        if (curr == null) {
            return null;
        }

        int compareRes = forCompare.compareTo(curr.value);

        return compareRes < 0 ? findNode(curr.lChild, forCompare) :
                (compareRes > 0 ? findNode(curr.rChild, forCompare) : curr);
    }

    @Override
    public boolean contains(T obj) {

        return findNode(root, checkingComparableObj(obj)) != null;

    }


    @Override
    public boolean add(T obj) { // SOLID, DI principle

        Comparable forCompare = checkingComparableObj(obj);

        if (root == null) {
            root = new TreeNode(null, obj, null, null);
            size++;
            return true;
        } else {
            // upcastiong Object o = new Man();
            // ClassCastException, down casting (Comparable)
            TreeNode parent = findFreePlace(root, forCompare);
            if (parent == null) {
                return false;// when unique elements
            }

            TreeNode child = new TreeNode(parent, obj, null, null);
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

        if (curr == null) {
            return curr;
        }

        int compareRes = forCompare.compareTo(curr.value);

        TreeNode next = compareRes < 0 ?
                curr.lChild : (compareRes > 0 ?
                curr.rChild : null);


        return findFreePlaceRec(next, forCompare);


    }

    private boolean linkChildWithParent(TreeNode parent, TreeNode child, boolean right) {
        if (right) {
            parent.rChild = child;
        } else {
            parent.lChild = child;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T obj) {

        if (root == null) {
            System.out.println("tree is empty");
            return false;

        }

        //if (contains(obj) == true) {
        TreeNode<T> curr = findNode(root, checkingComparableObj(obj));

        if (curr.rChild == null && curr.lChild == null) {

            Comparable temp = checkingComparableObj(curr.parent.value);

            if (temp.compareTo(curr.value) < 0) {
                curr.parent.rChild = null;
            }
            if (temp.compareTo(curr.value) > 0) {
                curr.parent.lChild = null;
            }

        } else if (curr.rChild != null && curr.lChild == null) {

            if (curr.rChild.rChild != null) {
                curr.value = curr.rChild.value;
                curr.rChild = curr.rChild.rChild;
                curr.lChild = curr.rChild.lChild;
            } else {
                curr.value = curr.rChild.value;
                curr.lChild = curr.rChild.lChild;

            }

            return true;

        } else if (curr.lChild != null && curr.rChild == null) {


            if (curr.lChild.rChild != null) {
                curr.value = curr.lChild.value;
                curr.rChild = curr.lChild.rChild;
                curr.lChild = curr.lChild.lChild;

            } else {
                curr.value = curr.lChild.value;
                curr.lChild = curr.lChild.lChild;

            }


            return true;

        } else {

            TreeNode<T> max = findMax(curr.lChild);
            if (curr.lChild.rChild != null) {
                curr.value = max.value;

                max.parent.rChild = null;
            } else {
                curr.value = curr.lChild.value;

                curr.lChild = curr.lChild.lChild;

            }

            return true;

        }


        return false;


    }


    @Override
    public void print() {
        TreeNode iterator = root;


        if (root == null) {
            System.out.println("tree is empty");
        } else {

            print(iterator);
        }

    }

    private void print(TreeNode<T> root) {

        TreeNode iterator = root;

        if (iterator == null) {
            return;
        }

        print(iterator.lChild);
        System.out.print(iterator.value + "->");
        print(iterator.rChild);

    }


    // inner or nested
    private static class TreeNode<T> {
        TreeNode<T> parent;
        T value;
        TreeNode<T> lChild;
        TreeNode<T> rChild;

        public TreeNode(TreeNode parent, T value,
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