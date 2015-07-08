package ua.artcode.HomeWork.Week2;

/**
 * Created by HOME on 08.07.2015.
 */
public interface IMyCMD {
    //void help();                       // show all available commands
    void cd();                         // changeCurrentLocation
    void find();                       // find file(dir)
    void dir();                         // show directoryContent
    void type();                        // show file (content)
    void del();                         // delete file
    void rd();                          // delete dir
    void mkdir();                       // create dir
    void md();                          // create file
    void tree();                        // show folder structure
    void copy();                        // copy file
    void fc();                          // compare content of files
    void showLocation();                // show now location
}
