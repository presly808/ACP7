package homeWork_week3;


/**
 * Created by ViTaLES on 18.07.2015.
 */
public class TestMyScanner {

    public static void main(String[] args) {
        IScanner scanner = new MyScanner(" 1 2 3   4 5  \n" +
                "dfdfdf \n" +
                "------");

        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }

        /*String s = "ldjgfldkgfj1111k;lk;lk333s here";

        StringBuilder sb = new StringBuilder();
        int elem = 0;
        // ������� ��������
        for (int i = 0; i < s.length(); i++) {

            // �������� �� �������������� � ������
            if (Character.isDigit(s.charAt(i))) {

                // ������� ������� � int ����������
                elem = Character.digit(s.charAt(i), 10);

                // ���������� ����� � ������-������ ��������� ����
                sb.append(elem + ", ");

            }
        }
        System.out.println(sb);*/
    }
}
