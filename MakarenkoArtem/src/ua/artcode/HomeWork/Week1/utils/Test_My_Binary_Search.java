package ua.artcode.HomeWork.Week1.utils;

import ua.artcode.HomeWork.Week1.utils.My_Binary_Search;

/**
 * Created by HOME on 02.07.2015.
 */
public class Test_My_Binary_Search {
    public static void main(String[] args) {
        int[] mas = new int[]{10, 15, 12, 7, 99};
        System.out.print("Starting mas: ");
        My_Binary_Search.print(mas);
        My_Binary_Search.sorting(mas);
        System.out.println(" ");
        System.out.print("Sortinng mas: ");
        My_Binary_Search.print(mas);
        System.out.println(" ");
        int find=12;
        System.out.println("Num " + find + " on " + My_Binary_Search.search(mas, find)+" position");
    }

}
