package ua.artcode.ds;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by serhii on 21.08.15.
 */
public class TreeTest {

    public static void main(String[] args) {
        /*Node n1 = new Node(60);
        Node n2 = new Node(37);
        Node n3 = new Node(30);
        n3.addNewNode(n1);
        n3.addNewNode(n2);

        Node n4 = new Node(75);
        n4.addNewNode(n3);
        n4.addNewNode(new Node(110));*/


        Node right = new Node(9,
                Arrays.asList(
                        new Node(37, Arrays.asList(
                                new Node(2),new Node(6))),
                        new Node(500, Arrays.asList(
                                new Node(1), new Node(11)))));




        Node left = new Node(75,
                Arrays.asList(new Node(30, Arrays.asList(
                                    new Node(36),new Node(60))),
                              new Node(110)));


        Node root = new Node(10, Arrays.asList(right,left));

        int max = TreeUtils.max(root);
        System.out.println(max);

    }


}

class TreeUtils {


    public static int max(Node start){

        int max = start.val;

        List<Node> children = start.getNodeList();

        // exit
        if(children == null || children.isEmpty()){
            return max;
        }


        for (Node child : children) {
            int returnedMax = max(child);
            if(returnedMax > max) {
                max = returnedMax;
            }
        }

        return max;

    }

}

class Node {

    int val;
    List<Node> nodeList = new LinkedList<>();

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> nodeList) {
        this.val = val;
        this.nodeList = nodeList;
    }

    public void addNewNode(Node node){
        nodeList.add(node);
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }
}


