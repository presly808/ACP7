package ua.artcode.sort;

public class SortHelper {

    private SortHelper(){}

    public static void sortBubble(int[] mas){
        if(mas.length == 0 || mas.length == 1){
            return;
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length - 1; j++) {
                if(mas[j] > mas[j+1]){
                    int temp = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = temp;
                }
            }
        }
    }

    public static void sortSelect(int[] mas){
        if(mas.length == 0 || mas.length == 1){
            return;
        }
        for (int i = 0; i < mas.length - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < mas.length; j++) {
                if(mas[temp] > mas[j]){
                    temp = j;
                }
            }
            int s = mas[i];
            mas[i] = mas[temp];
            mas[temp] = s;

        }
    }

    public static void sortInsert(int[] mas){
        if(mas.length == 0 || mas.length == 1){
            return;
        }
        int sorted = 0;
        for (int i = 1; i < mas.length; i++) {
            if(mas[sorted] > mas[i]){
                int index = i;
                for (int j = i - 1; j >= 0; j--) {
                    if(mas[index] < mas[j]){
                        int temp = mas[index];
                        mas[index--] = mas[j];
                        mas[j] = temp;
                    }
                }
            }
            sorted++;
        }
    }

    public static void sortQuick(int[] mas){
        if(mas.length == 0 || mas.length == 1){
            return;
        }
        quickHelperSort(mas, 0, mas.length);
    }

    private static void quickHelperSort(int[] mas, int h, int l){
        int mid = mas[h / 2];
        for (int i = l; i < h; i++) {
        }
    }

    public static void sortCount(int[] mas){
        int max = 0;
        for (int i = 0; i < mas.length; i++) {
            if(max < mas[i]){
                max = mas[i];
            }
        }
        int[] arr;
        if(max > mas.length) {
            arr = new int[max];
        }else{
            arr = new int[mas.length];
        }
        for (int i = 0; i < mas.length; i++) {
            arr[mas[i]] = arr[mas[i]] + 1;
        }
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                for (int j = 0; j < arr[i]; j++) {
                    mas[temp++] = i;
                }
            }
        }
    }




}
