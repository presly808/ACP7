package ua.artcode.week1.tree;

import java.util.Comparator;


public class MyTreeTest {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        BinarySearchTree tree = new BinarySearchTree(comparator);

        tree.add2(10);
        tree.add2(5);
        tree.add2(8);
        tree.add2(4);
        tree.add2(2);
        tree.add2(15);
        tree.add2(13);
        tree.add2(19);
        tree.add2(12);
        tree.add2(14);
        tree.add2(17);
        tree.add2(20);
        tree.add2(18);

        tree.print();
        //tree.remove(6);
        tree.remove(10);
        printTree(tree);
//
//        tree.remove(10);
//        printTree(tree);
//
//        tree.remove(11);
//        printTree(tree);
//
//        tree.remove(9);
//        printTree(tree);
        //tree.remove(8);
        //tree.print();
    }

    public static void printTree(BinarySearchTree tree) {
        System.out.println("start print");
        tree.print();
    }
}
