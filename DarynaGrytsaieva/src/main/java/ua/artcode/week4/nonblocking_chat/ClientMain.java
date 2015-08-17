package ua.artcode.week4.nonblocking_chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by dasha on 07.08.15.
 */
public class ClientMain {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Chat Window");
        frame.setPreferredSize(new Dimension(800, 500));
        ClientForm clientForm = new ClientForm();
        frame.setContentPane(clientForm.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        JButton sendButton = clientForm.getSendButton();

        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String messageText = clientForm.getMessageTypeTxtArea().getText();
                clientForm.getMessageHistoryTxtArea().append(messageText);
            }
        });
    }
}
