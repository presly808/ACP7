package week4.thread.task_shedular;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowCurrentTime implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss  dd-MMM-yyyy");
        System.out.println(sdf.format(currentDate));
        Toolkit.getDefaultToolkit();
    }
}
