package ua.artcode.week1.binaryTree;

import java.util.Iterator;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.add(20);
        tree.add(30);
        tree.add(15);
        tree.add(16);
        tree.add(9);
        tree.add(12);
        tree.add(7);
        tree.add(8);
        tree.add(13);

        Iterator iter = tree.getIterator();
        Object[] mas = new Object[9];
        mas[0] = iter.next();
        mas[1] = iter.next();
        mas[2] = iter.next();
        mas[3] = iter.next();
        mas[4] = iter.next();
        mas[5] = iter.next();
        mas[6] = iter.next();
        mas[7] = iter.next();
        mas[8] = iter.next();
        System.out.println(iter.hasNext());
    }
}
