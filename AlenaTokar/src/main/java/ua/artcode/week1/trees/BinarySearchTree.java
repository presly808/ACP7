package trees;


import java.util.Iterator;

/**
 * Created by tokar on 27.06.2015.
 */
public class BinarySearchTree<E> implements ITree<E> {


    private TreeNode root; // null
    private int size;

    @Override
    public boolean add(E obj) {
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
            //size++;

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

        TreeNode next = compareRes < 0 ? curr.lChild
                : (compareRes > 0 ? curr.rChild : null);


        return next == null ? curr : findFreePlaceRec(next, forCompare);


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

    public TreeNode deleteNode(TreeNode node, Object obj) {
        if (node == null) {
            return null;
        }
        Comparable valueForDelete = checkAndCast(obj);

        // TreeNode parent = nodeForDelete.parent;
        // Comparable valueParent = checkAndCast(parent.value);
        Comparable nodeValue = checkAndCast(node.value);

        if (valueForDelete.compareTo(nodeValue) < 0) {
            node.lChild = deleteNode(node.lChild, obj);
        } else if (valueForDelete.compareTo(nodeValue) > 0) {
            node.rChild = deleteNode(node.rChild, obj);

        } else {
            if (node.lChild == null) {
                TreeNode temp = node.rChild;
                node = null;
                return temp;
            } else if (node.rChild == null) {
                TreeNode temp = node.lChild;
                node = null;
                return temp;
            }

            TreeNode temp = MinValueNode(node.rChild);
            node.value = temp.value;
            node.rChild = deleteNode(node.rChild, temp.value);


        }
        return node;
    }

    public TreeNode MinValueNode(TreeNode node) {
        TreeNode curr = node;
        while (curr.lChild != null) {
            curr = curr.lChild;
        }
        return curr;
    }


    @Override
    public boolean remove(E obj) {

        //Comparable valueForDelete = checkAndCast(obj);
       root= deleteNode(root, obj);
        if (root != null) {
            return true;
        }




     /*  if(nodeForDelete.rChild==null&& nodeForDelete.lChild==null){
           if(parent.lChild==nodeForDelete){
               parent.lChild=null;

           }
           else if(parent.rChild==nodeForDelete){
               parent.rChild=null;
           }
           return true;

           }
        else if(nodeForDelete.rChild==null || nodeForDelete.lChild==null){
           if(nodeForDelete.lChild!=null){

               if(parent.lChild==nodeForDelete){
                   parent.lChild=nodeForDelete.rChild;
               }
               else{
                   parent.rChild=nodeForDelete.rChild;
                   nodeForDelete.rChild.parent=parent;
               }

           }
           else {
               if(parent.lChild==nodeForDelete){
                   parent.lChild=nodeForDelete.lChild;
               }
               else {
                   parent.rChild=nodeForDelete.lChild;
                   nodeForDelete.lChild.parent=parent;
               }
           }


           return true;



       }*/


        return false;
    }

    public TreeNode findMax(TreeNode curr) {
        if (curr.rChild == null) {
            return curr;
        }

        return findMax(curr.rChild);


    }

    @Override
    public boolean contains(Object obj) {
        return findNode(root, checkAndCast(obj)) != null;

    }


    private TreeNode findNode(TreeNode curr, Comparable forCompare) {
        if (curr == null) {
            return null;
        }

        int compareRes = forCompare.compareTo(curr.value);

        return compareRes < 0 ? findNode(curr.lChild, forCompare) :
                (compareRes > 0 ? findNode(curr.rChild, forCompare) : curr);
    }

    private void traverse(TreeNode node) {

        if (node == null) {
            return;
        }


        traverse(node.rChild);
        System.out.print(node.value + "->");
        traverse(node.lChild);

    }

    private Comparable checkAndCast(Object obj) {
        if (!(obj instanceof Comparable)) {
            throw new NotComparableException(obj.getClass().getName() + " doesn't implement Comparable");
        }
        return (Comparable) obj;
    }

    public void displayTree(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + "(");
            if (node.lChild != null) {
                displayTree(node.lChild);
            } else {
                System.out.print("null");
            }
            System.out.print(";");
            if (node.rChild != null) {
                displayTree(node.rChild);
            } else {
                System.out.print("null");
            }
            System.out.print(")");


        } else {
            System.out.print("Nothing");
        }
    }


    @Override
    public void print() {
        //traverse(root);
        displayTree(root);

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

        public TreeNode() {
        }
    }
}
