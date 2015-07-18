package console_commander.model;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Пользователь on 10.07.15.
 */
public class MyNIO extends IOException {

    int count;
    Path filePath = null;

    public MyNIO() {
    }


    public void run(String fileName) {
        filePath = Paths.get(fileName);//получаем обьект пути


        SeekableByteChannel fChan = null;// канал к файлу
        try {
            fChan = Files.newByteChannel(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ByteBuffer mBuff = ByteBuffer.allocate(128);//резерв буфера

        do {
            try {
                count = fChan.read(mBuff);//читаем в буфер
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (count != -1) {
                mBuff.rewind();//готовим буфер для чтения
                for (int i = 0; i < count; i++) {
                    System.out.println((char) mBuff.get());//читаем байты в буфер и
                    // отображаем их как символы
                }
            }
        }
        while (count != -1);
        System.out.println();
    }


}

