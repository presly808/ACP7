package week2.concole;


public interface FileHelper {
   String cd();//change current location
   void help(); //show all available commands
   void tree();//show folder structure
   void dir();//show directory content
   void find();//find file(dir)
   boolean mkdir();//create dir
   boolean mkfile(); //create file
   void type();//show file (content)
   boolean del();//delete file
   boolean rd();//delete directory



}
