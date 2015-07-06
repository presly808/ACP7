package ua.artcode.week1;

/**
 * Created by boris on 7/6/15.
 */
public class Tmp {
    public static int posoition = 0;
    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 0;
        arr[3] = 1;
        arr[4] = 0;
        arr[5] = 1;
        arr[6] = 0;
        arr[7] = 1;
        arr[8] = 0;
        arr[9] = 0;


        System.out.println(getPos(arr));
        System.out.println(getPos(arr));
        System.out.println(getPos(arr));
        System.out.println(getPos(arr));
        System.out.println(getPos(arr));
        System.out.println(getPos(arr));
        System.out.println(getPos(arr));
        double d;
        for(int i = 0; i < 10; i++){
            d = Double.valueOf(i)/Double.valueOf(10);
            System.out.println("d= " + d);
        }
    }

    public static int  getPos(int[] arr){
        for(; posoition < arr.length && arr[posoition] != 1; posoition++);
        if(posoition == arr.length){
            return -1;
        }
        return posoition++;
    }


}
