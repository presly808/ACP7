package ua.artcode.week1.tree;


public class TreeNode {
    Object value;
    TreeNode parent;
    TreeNode lChild;
    TreeNode rChild;

    public TreeNode(TreeNode parent, Object value, TreeNode lChaild, TreeNode rChild) {
        this.lChild = lChaild;
        this.parent = parent;
        this.rChild = rChild;
        this.value = value;
    }

    public TreeNode getrChild() {
        return rChild;
    }

    public void setrChild(TreeNode rChild) {
        this.rChild = rChild;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getlChild() {
        return lChild;
    }

    public void setlChild(TreeNode lChild) {
        this.lChild = lChild;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;

        TreeNode treeNode = (TreeNode) o;

        return !(value != null ? !value.equals(treeNode.value) : treeNode.value != null);

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
