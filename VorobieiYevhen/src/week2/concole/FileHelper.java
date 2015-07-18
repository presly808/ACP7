package week2.concole;


public interface FileHelper {
    String cd();//change current location
    void help(); //show all available commands
    void tree();//show folder structure
    boolean mkdir();//create dir
    boolean mkfile(); //create file
    String find();//find file(dir)
    void type();//show file (content)
    boolean del();//delete file
    void dir();//show directory content


}
