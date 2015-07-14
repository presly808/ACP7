package ua.artcode.sort;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 10);
            System.out.print(mas[i] + " ");
        }

        System.out.println();
        SortHelper.sortCount(mas);

        System.out.println(Arrays.toString(mas));

    }
}
