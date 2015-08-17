package ua.artcode.HomeWork.Week_4.Chat_P2P;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by HOME on 21.07.2015.
 */
public interface IClient {
    void showInfo ();

   String readMesFromServer(InputStream is) throws IOException;

    void writeMesOnServer(String line, OutputStream outputStream)throws IOException;
}
