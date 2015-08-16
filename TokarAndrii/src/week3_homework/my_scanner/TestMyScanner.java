package week3_homework.my_scanner;

public class TestMyScanner {


    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(" som textasd adsad zccaaadca acadas");
        System.out.println(scanner.hasNext());
        System.out.println(scanner.hasNext());
        System.out.println(scanner.hasNext());
        System.out.println(scanner.hasNext());
        System.out.println(scanner.hasNext());
        System.out.println(scanner.hasNext());
        System.out.println(scanner.hasNext());

        /*System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());*/
    }
}

