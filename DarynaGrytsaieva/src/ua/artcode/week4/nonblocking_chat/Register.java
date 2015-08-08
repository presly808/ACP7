package ua.artcode.week4.nonblocking_chat;

import javax.swing.*;
import java.awt.event.*;

public class Register extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;

    public Register() {
        setContentPane(contentPane);
        setModal(true);

        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRegister();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });

// call onExit() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onExit();
            }
        });

// call onExit() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onRegister() {
// add your code here
        dispose();
    }

    private void onExit() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Register dialog = new Register();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
