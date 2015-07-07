package ua.artcode.week1.tree;

import java.util.Comparator;


public class BinarySearchTree implements ITree {
    TreeNode root;
    private Comparator comparator;

    public BinarySearchTree(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean add(Object obj) {

        if (root == null) {
            root = new TreeNode(null, obj, null, null);
            return true;
        } else {
            TreeNode iter = root;
            while (iter != null) {
                if (comparator.compare(obj, iter.value) > 0) {
                    if (iter.rChild == null) {
                        iter.rChild = new TreeNode(iter, obj, null, null);
                        return true;
                    } else {
                        iter = iter.rChild;
                    }
                } else if (comparator.compare(obj, iter.value) < 0) {
                    if (iter.lChild == null) {
                        iter.lChild = new TreeNode(iter, obj, null, null);
                        return true;
                    } else {
                        iter = iter.lChild;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean add2(Object obj) {
        if (root == null) {
            root = new TreeNode(null, obj, null, null);
            return true;
        } else {
            return addReq(obj, root);
        }
    }

    public boolean addReq(Object obj, TreeNode noda) {
        return (getCompare(noda, obj) == 0) ? false
                : (getCompare(noda, obj) > 0)
                ? (noda.getrChild() != null)
                ? addReq(obj, noda.getrChild()) : addRChaild(noda, obj)
                : (noda.getlChild() != null) ? addReq(obj, noda.getlChild()) : addLChaild(noda, obj);


    }

    public int getCompare(TreeNode node, Object obj) {
        return comparator.compare(obj, node.getValue());

    }

    private boolean addRChaild(TreeNode node, Object val) {
        node.setrChild(new TreeNode(node, val, null, null));
        return true;
    }

    private boolean addLChaild(TreeNode node, Object val) {
        node.setlChild(new TreeNode(node, val, null, null));
        return true;
    }


    @Override
    public boolean remove(Object obj) {
        TreeNode nodeForRemove = getNodeByVal(root, obj);
        if (nodeForRemove != null) {
            System.out.println("Start to remove :" + nodeForRemove.getValue());
            boolean hasParent = nodeForRemove.getParent() != null;
            boolean isLeft = hasParent && comparator.compare(obj, nodeForRemove.getParent().getValue()) < 0;
            if (hasParent) {
                TreeNode parent = nodeForRemove.getParent();
                if (nodeForRemove.getlChild() == null && nodeForRemove.getrChild() == null) {
                    setChild(parent, null, isLeft);
                }
                if (nodeForRemove.getlChild() != null && nodeForRemove.getrChild() == null) {
                    setChild(parent, nodeForRemove.getlChild(), isLeft);

                }
                if (nodeForRemove.getlChild() == null && nodeForRemove.getrChild() != null) {
                    setChild(parent, nodeForRemove.getrChild(), isLeft);
                }
                if (nodeForRemove.getlChild() != null && nodeForRemove.getrChild() != null) {
                    TreeNode smallNode = getLast(nodeForRemove.getrChild(), true);
                    boolean isSmallInLeft = (comparator.compare(smallNode.getValue(), smallNode.getParent().getValue()) < 0);
                    if (smallNode.getrChild() != null) {
                        smallNode.getrChild().setParent(smallNode.getParent());
                    }
                    setChild(smallNode.getParent(), smallNode.getrChild(), isSmallInLeft);

                    smallNode.setlChild(nodeForRemove.getlChild());
                    nodeForRemove.getlChild().setParent(smallNode);


                    smallNode.setrChild(nodeForRemove.getrChild());
                    nodeForRemove.getrChild().setParent(smallNode);

                    smallNode.setParent(parent);

                    setChild(parent, smallNode, isLeft);
                }
            } else {
                if (nodeForRemove.getlChild() == null && nodeForRemove.getrChild() == null) {
                    nodeForRemove.setValue(null);
                }
                if (nodeForRemove.getlChild() != null && nodeForRemove.getrChild() != null) {
                    TreeNode smallNode = getLast(nodeForRemove.getrChild(), true);
                    if (smallNode.getParent() != null) {
                        boolean isSmallInLeft = (comparator.compare(smallNode.getValue(), smallNode.getParent().getValue()) < 0);
                        setChild(smallNode.getParent(), smallNode.getrChild(), isSmallInLeft);
                    }
                    setChild(smallNode, nodeForRemove.getlChild(), true);
                    setChild(smallNode, nodeForRemove.getrChild(), false);
                    setParent(smallNode, nodeForRemove.getlChild());
                    setParent(smallNode, nodeForRemove.getrChild());
                    setParent(null, smallNode);
                    changeParent(root, smallNode);
                    System.out.println();
                } else {
                    TreeNode child = (root.getlChild() != null) ? root.getlChild() : root.getrChild();
                    changeParent(root, child);
                }
            }
        }
        return true;
    }

    private void changeIfAllChild(TreeNode node, TreeNode smalNode) {


    }

    private void setParent(TreeNode parent, TreeNode child) {
        child.setParent(parent);
    }

    private void changeParent(TreeNode parent, TreeNode child) {
        parent.setValue(child.getValue());
        parent.setrChild(child.getrChild());
        parent.setlChild(child.getlChild());
    }

    private TreeNode getLast(TreeNode node, boolean isSmall) {
        if (isSmall) {
            return (node.getlChild() == null) ? node : getLast(node.getlChild(), isSmall);
        } else
            return (node.getrChild() == null) ? node : getLast(node.getrChild(), isSmall);
    }

    private void setChild(TreeNode parent, TreeNode child, boolean isLeft) {
        if (child != null) {
            if (isLeft)
                parent.setlChild(child);
            else
                parent.setrChild(child);
            child.setParent(parent);
        } else {
            if (isLeft)
                parent.setlChild(child);
            else
                parent.setrChild(child);
        }
    }

    private TreeNode getNodeByVal(TreeNode node, Object obj) {
        if (node == null) {
            return node;
        }
        int comp = comparator.compare(obj, node.getValue());
        return (comp == 0) ? node : (comp > 0) ? getNodeByVal(node.getrChild(), obj) : getNodeByVal(node.getlChild(), obj);
    }

    @Override
    public boolean contains(Object obj) {
        return isExist(root, obj);
    }

    private boolean isExist(TreeNode node, Object obj) {
        if (node == null) {
            return false;
        }
        int comp = comparator.compare(obj, node.getValue());
        return (comp == 0) ? true : (comp > 0) ? isExist(node.getrChild(), obj) : isExist(node.getlChild(), obj);
    }

    @Override
    public void print() {
        traverse(root);
    }

    private void traverse(TreeNode node) {

        if (node == null) {
            return;
        }

        traverse(node.lChild);
        System.out.println(node.value);
        traverse(node.rChild);
    }

}
