package week1.my_tree_set;

import java.util.Set;
import java.util.TreeSet;


public class TestTreeSet {
    public static void main(String[] args) {


        BinarySearchTee mySet = new BinarySearchTee();

        User user1 = new User("Antony", 18);
        User user2 = new User("Bob", 22);
        User user3 = new User("Carl", 31);
        User user4 = new User("Antony", 18);
        User user5 = new User("Din", 45);
        User user6 = new User("Euclid", 16);
        User user7 = new User("Fagot", 78);
        User user8 = new User("Georg", 18);
        User user9 = new User("Hana", 29);
        User user10 = new User("Iraq", 10);
        User user11 = new User("Jack", 11);
        User user12 = new User("Kelly", 22);
        User user13 = new User("Lana", 19);
        User user14 = new User("Monika", 33);
        User user15 = new User("Nick", 34);
        User user16 = new User("Owen", 34);
        User user17 = new User("Peter", 45);
        User user18 = new User("Rankle", 16);
        User user19 = new User("Susy", 19);
        User user20 = new User("Tom", 57);
        User user21 = new User("Una", 17);
        User user22 = new User("Viva", 21);


        System.out.println(mySet.size());
        mySet.add(user8);

        mySet.add(user6);
        mySet.add(user5);
        mySet.add(user3);
        mySet.add(user2);
        mySet.add(user7);
        mySet.add(user4);
        mySet.add(user9);
        mySet.add(user10);
        mySet.add(user22);
        mySet.add(user18);
        mySet.add(user11);
        mySet.add(user12);
        mySet.add(user13);
        mySet.add(user16);
        mySet.add(user15);
        mySet.add(user14);
        mySet.add(user19);
        mySet.add(user20);
        mySet.add(user21);
        mySet.add(user17);
        mySet.add(user1);
        System.out.println(mySet.size());
        System.out.println(mySet.contains(user1));
        System.out.println(mySet.contains(user10));
        mySet.delete(user6);
        mySet.print();
        System.out.println(mySet.size());

        System.out.println(mySet.findMin());
        System.out.println(mySet.findMax());

    }

}
