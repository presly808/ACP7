package ua.artcode.week1;


public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Element: %d has index: %d\n", i, myBinarySearch(array, i));
        }
    }

    public static int myBinarySearch(int[] array, int number) {
        int start = 0;
        int end = array.length - 1;
        for (; start <= end; ) {

            int position = start + (end - start) / 2;
            if (array[position] == number) {
                return position;
            }
            if (array[position] > number) {
                end = position - 1;
            } else {
                start = position + 1;
            }
        }
        return -1;
    }
}
