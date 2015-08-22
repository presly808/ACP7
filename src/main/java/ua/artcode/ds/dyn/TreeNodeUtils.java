package ua.artcode.ds.dyn;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by serhii on 21.08.15.
 */
public class TreeNodeUtils {


    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(null, 10, null, null);
        TreeNode n15 = new TreeNode(null, 15, n10, null);



        TreeNode n46 = new TreeNode(null, 46, null, null);
        TreeNode n30 = new TreeNode(null, 30, null, null);
        TreeNode n45 = new TreeNode(null, 45, null, n46);
        TreeNode n35 = new TreeNode(null, 35, n30, n45);

        TreeNode n25 = new TreeNode(null, 25, n15, n35);


        TreeNode n60 = new TreeNode(null, 60, null, null);
        TreeNode n80 = new TreeNode(null, 80, null, null);
        TreeNode n70 = new TreeNode(null, 70, n60, n80);

        TreeNode n50 = new TreeNode(null, 50, n25, n70);

        ResultSequence rs = buildLongestNodeSequence(n50);

        List<Object> seq = rs.getRes();

        for (Object o : seq) {
            System.out.print(o + "->");
        }


    }

    public static ResultSequence buildLongestNodeSequence(TreeNode node){

        if(node == null){
            return new ResultSequence(0);
        }

        ResultSequence left = buildLongestNodeSequence(node.lChild);
        ResultSequence right = buildLongestNodeSequence(node.rChild);

        if(left.getSize() > right.getSize()){
            left.addToList(node.value);
            left.incrementSize();
            return left;
        } else {
            right.addToList(node.value);
            right.incrementSize();
            return right;
        }

    }

}

class ResultSequence {
    int size;
    List<Object> res = new LinkedList<>();

    public ResultSequence(int size) {
        this.size = size;
    }

    public ResultSequence(int size, List<Object> res) {
        this.size = size;
        this.res = res;
    }

    public ResultSequence() {
    }

    public void incrementSize(){
        size++;
    }

    public void addToList(Object el){
        res.add(0,el);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Object> getRes() {
        return res;
    }

    public void setRes(List<Object> res) {
        this.res = res;
    }
}

class TreeNode {
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
