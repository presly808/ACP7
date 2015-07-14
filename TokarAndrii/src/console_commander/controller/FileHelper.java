package console_commander.controller;

import console_commander.model.MyNIO;

import java.io.File;


/**
 * Created by Пользователь on 06.07.15.
 */
public class FileHelper implements IOFileHelper {


    @Override
    public void help() {

        System.out.println("help - show all available commands\n" +
                "cd  - change current location\n" +
                "dir - show directoryContent\n" +
                "type - show file\n" +
                "rd - delete file\n" +
                "mkdir - create directory\n" +
                "copy - copy file\n" +
                "fc - compare content of files");

    }

    @Override
    public void cd(String path) {
        String curr = null;
        File file = new File(path);
        curr = file.getAbsolutePath();
        System.out.println(curr + "\\" + ">");

    }

    @Override
    public String find(String fileName, File file) {

        String ret = "";

        if (file.getName().contains(fileName)) {

            ret += file.getAbsolutePath().toString() + "\n";
        }

        if (file.isDirectory() && file.listFiles() != null) {
            for (File child : file.listFiles()) {
                ret += find(fileName, child);
            }
        }
        System.out.println(ret);
        return ret;

    }

    @Override
    public void dir(String path) {
        String ret = "";
        File file = new File(path);
        for (File child : file.listFiles()) {

            if (child.isDirectory() == true) {
                ret = child.getName() + " <DIR>";
                System.out.println(ret);
            } else if (child.isFile() == true) {
                ret = child.getName();
                System.out.println(ret);
            }
        }

        System.out.println(path + "\\" + ">");

    }

    @Override
    public void type(String fileName) {//todo
        MyNIO myNIO = new MyNIO();
        myNIO.run(fileName);

    }

    @Override
    public boolean rd() {
        return false;
    }

    @Override
    public File mkdir() {
        return null;
    }

    @Override
    public boolean copy() {
        return false;
    }

    @Override
    public String fc() {
        return null;
    }
}
