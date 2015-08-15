package week4.homeWorkWeek4.myChat.model;

import week4.homeWorkWeek4.myChat.controller.IOSerialMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.*;

/**
 * Created by Пользователь on 22.07.15.
 */
public class Server {

    private MessageMy message;
    private String ipClient;
    private Map<String, Client> clients = new TreeMap();
    private int port = 8889;
    private ExecutorService executorService;
    private Client client;


    private ServerSocket serverSocket;

    public Server() {

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        run();

    }

    public void run() {


        while (true) {

            executorService = Executors.newCachedThreadPool();
            Future callableFuture1 = executorService.submit(new SendMessage());
            Future<MessageMy> callableFuture2 = executorService.submit(new ReciveMessage());
            try {
                MessageMy res = callableFuture2.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

    }

    private class ReciveMessage implements Callable<MessageMy> {

        private String path;

        private MessageMy messageMy;


        @Override
        public MessageMy call() throws Exception {

            Socket client = serverSocket.accept();

           /* InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();*/
            //dont clear if it needs


            IOSerialMessage ioSerialMessage = new IOSerialMessage();
            messageMy = ioSerialMessage.load(path);

            return messageMy;
        }
    }


    private class SendMessage implements Runnable {

        private String path;

        private MessageMy messageMy;


        @Override
        public void run() {

            try {
                Socket client = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

           /* InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();*/
            //dont clear if it needs


            IOSerialMessage ioSerialMessage = new IOSerialMessage();
            ioSerialMessage.save(path, message);

        }
    }


}
