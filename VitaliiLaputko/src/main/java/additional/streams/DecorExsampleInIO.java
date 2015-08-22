package additional.streams;

import java.io.*;

/**
 * Created by serhii on 24.07.15.
 */
public class DecorExsampleInIO {

    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("/home/serhii/dev/IdeaProjects/ACP7/VitaliiLaputko/temp/write.txt")));
        Character c = dis.readChar();
        System.out.println(c);
    }
}
