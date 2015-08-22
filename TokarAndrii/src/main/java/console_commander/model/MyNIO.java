package console_commander.model;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MyNIO extends IOException {

    int count;
    Path filePath = null;

    public MyNIO() {
    }


    public void run(String fileName) {
        filePath = Paths.get(fileName);//


        SeekableByteChannel fChan = null;//
        try {
            fChan = Files.newByteChannel(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ByteBuffer mBuff = ByteBuffer.allocate(128);//
        //  do {
            try {
                count = fChan.read(mBuff);//
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (count != -1) {
                mBuff.rewind();//
                for (int i = 0; i < count; i++) {
                    System.out.println((char) mBuff.get());//                   // ���������� �� ��� �������
                }
            }
        }
      /*  while (count != -1);
        System.out.println();*/
    }


}

