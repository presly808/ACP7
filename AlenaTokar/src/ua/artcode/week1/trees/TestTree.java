package trees;

import java.util.Comparator;

/**
 * Created by tokar on 27.06.2015.
 */
public class TestTree {
    public static void main(String[] args) {



        BinarySearchTree<Integer> bTree = new BinarySearchTree();
        //comparator=(Integer)45;
        bTree.add(45);
        bTree.add(11);
        bTree.add(100);
        bTree.add(9);
        bTree.add(68);
        bTree.add(33);
        bTree.add(88);

        bTree.print();
       System.out.println("******************");
        bTree.remove(45);
        bTree.print();

        System.out.println("******************");
        bTree.remove(68);

        bTree.print();
        System.out.println("******************");
        bTree.remove(88);
        bTree.print();

        System.out.println("******************");
        bTree.remove(33);
        bTree.print();

        System.out.println("******************");
        bTree.remove(100);
        bTree.print();

        System.out.println("******************");
        bTree.remove(11);
        bTree.print();

        System.out.println("******************");
        bTree.remove(9);
        bTree.print();









//System.out.println(bTree.contains(555));
    }



}
