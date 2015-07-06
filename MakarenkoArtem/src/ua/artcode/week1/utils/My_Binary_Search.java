package ua.artcode.week1.utils;

/**
 * Created by HOME on 02.07.2015.
 */
public class My_Binary_Search {

    public static void sorting(int[] mas) {
        int vrem;
        for (int i = mas.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (mas[j] > mas[j + 1]) {
                    vrem = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = vrem;
                }
            }
        }
    }

    public static int search(int[] mas, int find) {
        int fir = 0;
        int last = mas.length - 1;
        while (fir <= last) {
            int mid = fir + (last - fir) / 2;
            if (find < mas[mid])
                last = mid - 1;
            else {
                if (find > mas[mid])
                    last = mid + 1;
                else
                    return mid;
            }
        }
        return -1;
    }

    public static void print(int[] mas) {
        for(int i=0;i<mas.length;i++) {
            System.out.print(mas[i] + " ");
        }
    }

}