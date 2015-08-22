package ua.artcode.HomeWork.Week2;

/**
 * Created by HOME on 08.07.2015.
 */
public class MyCMD implements IMyCMD {

    //@0O0verride
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

    @Override
    public void mkdir() {

    }

    @Override
    public void md() {

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

    @Override
    public void showLocation() {

    }
}
