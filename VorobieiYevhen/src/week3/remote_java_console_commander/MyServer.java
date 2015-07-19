package week3.remote_java_console_commander;

import week2.concole.Console;
import week3.socket.RemoteUser;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by serhii on 12.07.15.
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);

        week3.remote_java_console_commander.Console remoteConsole = new week3.remote_java_console_commander.Console(ss);
        remoteConsole.window();


    }
}