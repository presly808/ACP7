package homeWork.BinarySearchTree;

public class TestTree {


    public static void main(String[] args) {


        BinarySearchTree binarySearchTree = new BinarySearchTree();


        binarySearchTree.add(500);
        binarySearchTree.add(250);
        binarySearchTree.add(750);
        binarySearchTree.add(125);
        binarySearchTree.add(375);
        binarySearchTree.add(75);
        binarySearchTree.add(150);
        binarySearchTree.add(50);
        binarySearchTree.add(80);
        binarySearchTree.add(130);
        binarySearchTree.add(175);
        binarySearchTree.add(300);
        binarySearchTree.add(400);
        binarySearchTree.add(275);
        binarySearchTree.add(325);
        binarySearchTree.add(25);
        binarySearchTree.add(85);
        binarySearchTree.add(730);
        binarySearchTree.add(760);
        binarySearchTree.add(720);
        binarySearchTree.add(735);
        binarySearchTree.add(765);
        binarySearchTree.add(770);
        binarySearchTree.add(20);
        binarySearchTree.add(15);
        binarySearchTree.add(21);
        binarySearchTree.add(10);
        binarySearchTree.add(126);
        binarySearchTree.add(133);
        binarySearchTree.add(132);
        binarySearchTree.add(134);
        //binarySearchTree.add(764);todo


        binarySearchTree.print();
        System.out.println();

        System.out.println(binarySearchTree.contains(250));

        System.out.println(binarySearchTree.remove(760));//don't delete 20;
        binarySearchTree.remove(300);

        binarySearchTree.print();


    }
}
