package console_commander.controller;

import java.io.File;

public interface IOFileHelper  {

    public void help();//show all available commands

    public void cd(String path);//changeCurrentLocation
    // works cuch as; cd_Path

    public  String find (String fileName,File file);//find file

    public void dir(String path);//show directoryContent

    public void type(String fileName);//show file

    public boolean rd();//delete file

    public File mkdir();//create directory

    public boolean copy();//copy file

    public String fc();//compare content of files
}
