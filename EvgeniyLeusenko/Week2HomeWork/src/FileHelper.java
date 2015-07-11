import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
                "7. Create dir - mkdir+pathname(D:\\***)" +"\n"+
                "8. Create file - new+pathname(C:\\***)" +"\n"+
                "9. Show folder structure - tree" +"\n"+
                "10. Copy file - copy" +"\n"+
                "11. Compare content of files - fc" +"\n"+
                "12. For help - help" +"\n" +
                "13. For file content percentage information - content"+"\n" +
                "13. For exit - exit");

    }
    public void dir(File ourFile){
        String []listFolder=ourFile.list();
        for(String s:listFolder)
            System.out.println(s);
    }

    public boolean find(File ourFile,String name){
        String []listFolder=ourFile.list();
        for(String s:listFolder){
            if(s.equals(name)){return true;};
        }
        return false;
    }

    public void showTree(File ourFile){
        String []listFolder=ourFile.list();
        for(String s:listFolder){
            System.out.println(s);;
        }
    }

    public void copy(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

    public double [] folderContent(String []fileList){
        double [] arr= new double[4];//1-video,2-audio,3-txt,4-other
        for(String s:fileList){
            if(s.endsWith(".avi")) arr[0]++;
            if(s.endsWith(".mp3")) arr[1]++;
            if(s.endsWith(".txt")) arr[2]++;
            else arr[3]++;
            }

        return arr;
    }


}
