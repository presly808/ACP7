package ua.artcode.HomeWork.Week_4.Chat_P2P;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by HOME on 22.07.2015.
 */
public interface IServer {

    String connectionInfo();

    String readFromUser(InputStream is) throws IOException;

    void sendToUser(String line, OutputStream outputStream)throws IOException;
}
