package additional.streams;

import java.io.FileNotFoundException;

/**
 * Created by serhii on 24.07.15.
 */
public class TestIOUtils {


    public static void main(String[] args) throws FileNotFoundException {
        String res = IOUtils.readAllByISWithBuff("/home/serhii/dev/IdeaProjects/ACP7/VitaliiLaputko/src/homework_week3/MyScanner.java");
        System.out.println(res);


        IOUtils.writeByWriter("/home/serhii/dev/IdeaProjects/ACP7/VitaliiLaputko/temp/write.txt", "Hello to file Сершіваіва");
    }
}
