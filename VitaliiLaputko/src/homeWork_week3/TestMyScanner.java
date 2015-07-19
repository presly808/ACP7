package homeWork_week3;


/**
 * Created by ViTaLES on 18.07.2015.
 */
public class TestMyScanner {

    public static void main(String[] args) {
        IScanner scanner = new MyScanner(" 1 2 3   4 5  ");

        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }


/*        System.out.println(scanner.hasNext());

        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());*/
    }
}
