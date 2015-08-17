package ua.artcode.week4.nonblocking_chat;

import javax.swing.*;

/**
 * Created by dasha on 07.08.15.
 */
public class ClientForm {
    private JTextArea messageHistoryTxtArea;
    private JButton sendButton;
    private JTextArea messageTypeTxtArea;
    private JPanel mainPanel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public JTextArea getMessageHistoryTxtArea() {
        return messageHistoryTxtArea;
    }

    public JTextArea getMessageTypeTxtArea() {
        return messageTypeTxtArea;
    }
}
