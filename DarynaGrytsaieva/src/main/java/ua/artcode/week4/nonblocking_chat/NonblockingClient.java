package ua.artcode.week4.nonblocking_chat;


import java.io.*;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;


/**
 * Created by dasha on 04.08.15.
 */
public class NonblockingClient {
    private SocketChannel socketChannel;
    private Selector selector;
    private String name;

    public static void main(String[] args) throws IOException {
        NonblockingClient client = new NonblockingClient();
        try {
            client.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException, InterruptedException {
        try {
            initSocketChannel("localhost", 1111);

        } catch (ConnectException e) {
            System.out.println("Chat limit is exceeded. Please try later. ConEx");
            System.exit(0);

        } catch (SocketException e) {
            System.out.println("Chat limit is exceeded. Please try later. SockEx");
            socketChannel.close();
            System.exit(0);

        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your login: ");
        name = scan.nextLine();
        System.out.println("Start typing...");


        processOutgoingMessages();


        while (true) {

            int readyChannels = selector.select();
            if (readyChannels == 0)
                continue;

            processIncomingMessages();
        }


    }

    private void processIncomingMessages() {
        Iterator keyIter = selector.selectedKeys().iterator();
        while (keyIter.hasNext()) {
            SelectionKey selKey = (SelectionKey) keyIter.next();
            keyIter.remove();

            if (selKey.isReadable()) {
                socketChannel = (SocketChannel) selKey.channel();
                try {
                    while (true) {

                        ByteBuffer buf = ByteBuffer.allocate(4);
                        int read = socketChannel.read(buf);
                        if (read == 0) break;

                        int messageSize = buf.getInt(0);

                        buf.clear();
                        buf = ByteBuffer.allocate(messageSize);
                        socketChannel.read(buf);

                        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buf.array()));
                        buf.clear();


                        Message message = (Message) ois.readObject();
                        System.out.println(message.toString());
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println("Chat limit is exceeded. Please try later. IOEX IncMes");
                    try {
                        socketChannel.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        }
    }

    private void initSocketChannel(String hostname, int port) throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(hostname, port));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);

    }

    private void processOutgoingMessages() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);

                while (scanner.hasNextLine()) {
                    String text = scanner.nextLine();
                    if(text.isEmpty()) continue;

                    Message message = new Message(name, text);

                    try {
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(bos);

                        oos.writeObject(message);
                        oos.flush();
                        oos.close();
                        socketChannel.write(ByteBuffer.wrap(bos.toByteArray()));


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

    }
}

