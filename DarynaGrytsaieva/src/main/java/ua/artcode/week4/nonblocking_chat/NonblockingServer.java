package ua.artcode.week4.nonblocking_chat;


import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by dasha on 04.08.15.
 */
public class NonblockingServer {
    private ServerSocketChannel serverChannel;
    private Selector selector;
    private Properties properties;
    private boolean isNewClient;

    private static volatile HashMap<SocketChannel, String> clientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        NonblockingServer server = new NonblockingServer();
        server.run();
    }


    //------------------------------------------------------------

    public void run() throws IOException {
        initServerSocketChannel();

        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;

            Iterator keyIter = selector.selectedKeys().iterator();
            while (keyIter.hasNext()) {
                SelectionKey selKey = (SelectionKey) keyIter.next();
                keyIter.remove();

                if (selKey.isAcceptable()) {
                    if (clientMap.size() < Integer.parseInt(properties.getProperty("maxUsers"))) {
                        initNewClientChannel();
                    } else {
                        selKey.channel().close();
                    }
                    continue;
                }
                if (selKey.isReadable()) {
                    processClient(selKey);
                }

            }
        }
    }

    private void initServerSocketChannel() throws IOException {
        serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);

        properties = new Properties();
        properties.load(new FileInputStream("settings.properties"));
        String port = properties.getProperty("port");

        serverChannel.socket().bind(new InetSocketAddress(Integer.parseInt(port)));
        selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    private void initNewClientChannel() throws IOException {
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);
        isNewClient = true;
    }

    private void processClient(SelectionKey selKey) throws IOException {
        SocketChannel clientChannel = (SocketChannel) selKey.channel();

        try {
            Message message = readMessageFromClient(clientChannel);
            if (isNewClient) {
                registerNewClientToChat(clientChannel, message); // women logic
            }

            sendMessageToAllClients(message);
            addToHistoryFile(message.toString());


        } catch (StreamCorruptedException e) {
            unregisterClient(clientChannel);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void registerNewClientToChat(SocketChannel clientChannel, Message message) throws IOException {
        Message serverMessage = new Message("", "------- New client *" + message.getName() + "* has joined (" + (clientMap.size() + 1) + " users) -------");

        sendMessageToAllClients(serverMessage);

        clientMap.put(clientChannel, message.getName());
        addToHistoryFile(serverMessage.getText());

        isNewClient = false;
    }

    private void unregisterClient(SocketChannel clientChannel) throws IOException {
        Message serverMessage = new Message("", "------- Client *" + clientMap.get(clientChannel) + "* left (" + (clientMap.size() - 1) + " users) -------");
        clientMap.remove(clientChannel);

        sendMessageToAllClients(serverMessage);
        addToHistoryFile(serverMessage.getText());

        clientChannel.close();

    }

    private void sendMessageToAllClients(Message message) {
        System.out.println(message.toString());
        for (SocketChannel socketChannel : clientMap.keySet()) {
            try {

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);

                oos.writeObject(message);
                oos.flush();
                byte[] serializedMessageObject = bos.toByteArray();

                int messageSize = serializedMessageObject.length;
                socketChannel.write(ByteBuffer.allocate(4).putInt(0, messageSize));//sending header with size of upcoming message

                socketChannel.write(ByteBuffer.wrap(serializedMessageObject));//sending message

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private Message readMessageFromClient(SocketChannel clientChannel) throws IOException, ClassNotFoundException {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        clientChannel.read(buf);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buf.array()));
        return (Message) ois.readObject();
    }


    private void addToHistoryFile(String message) throws IOException {
        File file = new File("/home/dasha/workspace/history.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        fw.write(message + "\n");
        fw.close();
    }

}

