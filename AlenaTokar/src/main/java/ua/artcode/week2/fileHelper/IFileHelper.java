package ua.artcode.week2.fileHelper;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by tokar on 07.07.2015.
 */
public interface IFileHelper {
    public void showAllCommands();

    public File changeCurrentLocation(String path);

    public String find(String keyWord,File file) throws FileNotFoundException;//find file

    public void dir(String path);//show directoryContent

    public String type();//show file

    public boolean rd();//delete file

    public File mkDir();//create directory

    public boolean copy();//copy file

    public String fc();//compare content of files


}
