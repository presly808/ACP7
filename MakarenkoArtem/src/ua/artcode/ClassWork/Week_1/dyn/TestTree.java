package ua.artcode.ClassWork.Week_1.dyn;

import ua.artcode.ClassWork.Week_1.dyn.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 28.06.15.
 */
public class TestTree {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.add(100);
        tree.add(50);
        tree.add(75);
        tree.add(25);
        tree.add(140);
        tree.add(110);

        tree.print();



    }

    private static void testPrint(ArrayList list){
        list.isEmpty();
    }
}
