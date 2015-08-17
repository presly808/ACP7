package ua.artcode.HomeWork.Week_2;

import java.io.FileNotFoundException;

/**
 * Created by HOME on 08.07.2015.
 */
public class TestMyCMD {

    public static void main(String[] args)throws FileNotFoundException{
        String location = "C:/Java" ;
        MyCMD.showLocation(location);
        MyCMD.help();

        String file= "Test.txt";
        MyCMD.md(location, file);

        String newLocation= "NewFolder";
        MyCMD.mkdir(location,newLocation);

    }

}
