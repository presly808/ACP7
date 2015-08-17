package ua.artcode.HomeWork.Week_2;

import java.io.*;

/**
 * Created by HOME on 08.07.2015.
 */
public class MyCMD implements IMyCMD {

    //@Override
    public static void help() {
        System.out.println("help    show all available commands");
        System.out.println("cd      changeCurrentLocation");
        System.out.println("find    find file(dir)");
        System.out.println("dir     show directoryContent");
        System.out.println("type    show file (content)");
        System.out.println("del     delete file");
        System.out.println("rd      delete dir");
        System.out.println("mkdir   create dir");
        System.out.println("md      create file");
        System.out.println("tree    show folder structure");
        System.out.println("copy    copy file");
        System.out.println("fc      compare content of files");
    }

    @Override
    public void cd() {

    }

    @Override
    public void find() {

    }

    @Override
    public void dir() {

    }

    @Override
    public void type() {

    }

    @Override
    public void del() {

    }

    @Override
    public void rd() {

    }

    //@Override
    public static void mkdir(String location,String newLocation) throws FileNotFoundException{
        File os = null;
        String result = new StringBuffer(location).append("/").toString();
        String fResult = new StringBuffer(result).append(newLocation).toString();
        String finalResult = new StringBuffer(fResult).append("/").toString();
        os= new File(finalResult);
        os.mkdir();
    }

    //@Override
    public static void md(String location, String file) throws FileNotFoundException {
        OutputStream os = null;
        try{
            String result = new StringBuffer(location).append("/").toString();
            String finalResult = new StringBuffer(result).append(file).toString();
            os= new FileOutputStream(finalResult);
            os.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(os!=null){
                    os.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void tree() {

    }

    @Override
    public void copy() {

    }

    @Override
    public void fc() {

    }

    //@Override
    public static void showLocation(String location) {
        System.out.println(location);
    }
}
