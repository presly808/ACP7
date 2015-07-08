package ua.artcode.week1.binaryTree;

import java.util.Iterator;

/**
 * Created by Daryna on 27-Jun-15.
 */
public class TreeMain {
    public static void main(String[] args) {


        BinarySearchTree<Integer> tr = new BinarySearchTree<>();
        tr.add(15);
        tr.add(20);
        tr.add(25);
        tr.add(22);
        tr.add(10);
        tr.add(12);
        tr.add(19);
        tr.add(26);
        tr.add(6);

        System.out.println("Size: " + tr.getSize());
        System.out.println("Contains 10: " + tr.contains(10));

        tr.traversalPrint();

        System.out.println("Minimum: " + tr.findMin());
        System.out.println("Maximum: " + tr.findMax());

        //tr.remove(25);
        tr.leftRotate(20);
        //tr.rightRotate(10);
        tr.traversalPrint();
        System.out.println("Size: " + tr.getSize());


        System.out.println("Iterator:");
        Iterator<Integer> iterator = tr.iterator();

        while(iterator.hasNext())
            System.out.print(iterator.next()+" ");


    }
}
