package ua.artcode.HomeWork.Week_4.Chat_P2P;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by HOME on 22.07.2015.
 */
class Server implements IServer {

    @Override
    public String connectionInfo() {
        String info = String.format("Hello from server, time %tc", new Date());
        System.out.println(info);
        return info;
    }

    @Override
    public String readFromUser(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        int read = 0;
        while ((read = is.read()) != -1) {
            sb.append((char) read);
        }
        return sb.toString();
    }

    @Override
    public void sendToUser(String line, OutputStream outputStream)throws IOException{
        outputStream.write(line.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
