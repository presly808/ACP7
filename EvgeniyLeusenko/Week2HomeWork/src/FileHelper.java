import java.io.File;
import java.util.Scanner;

/**
 * Created by Пользователь on 06.07.2015.
 */
public class FileHelper {

    public void menu() {
        System.out.println("Введите одну из команд:" +"\n"+
                "1.Change current location in format C:/- cd+new pathName" +"\n"+
                "2.Find file - find+pathName" +"\n"+
                "3.Show directoryContent - dir"+"\n"+
                "4.Show file content - dir+file" +"\n"+
                "5.Delete file - del+file" +"\n"+
                "6.Show file content - type" +"\n"+
                "6. Delete file or dir - del" +"\n"+
                "7. Create dir - mkdir" +"\n"+
                "8. Create file - new+filename" +"\n"+
                "9. Show folder structure - tree" +"\n"+
                "10. Copy file - copy" +"\n"+
                "11. Compare content of files - fc" +"\n"+
                "12. For help - help" +"\n"+
                "13. For exit - exit");

    }
    public void dir(File ourFile){
        String []listFolder=ourFile.list();
        for(String s:listFolder)
            System.out.println(s);
    }

    public void fileIsDirectory(){

    }

    public void findFile(){

    }
}
