package week1;

/**
 * Created by Daryna on 01-Jul-15.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        print(arr);

        System.out.println(binarySearch(arr, 7));
    }

    public static int binarySearch(int[] arr, int x) {

        int pointElement;
        int pointIndex;
        int start = 0;
        int end = arr.length - 1;

        while (true) {
            pointIndex = (end + start) / 2;
            pointElement = arr[pointIndex];

            if (x == pointElement)
                return pointIndex;

            if (start == end)
                return -1;

            if (x >= pointElement) {
                start = pointIndex + 1;

            } else {
                end = pointIndex - 1;
            }
        }
    }


    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }


}

