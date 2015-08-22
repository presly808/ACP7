package ua.artcode.week2.fileHelper;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by tokar on 09.07.2015.
 */
public class FileHelper implements IFileHelper {
    @Override
    // Help
    public void showAllCommands() {
        System.out.println(

                "show all available commands        help" + "\n" +
                        "changeCurrentLocation              cd" + "\n" +
                        "find file                     find" + "\n" +
                        "show directoryContent              dir" + "\n" +
                        "show file (content)                type" + "\n" +
                        "delete file or dir                 del" + "\n" +
                        "create dir                         mkdir" + "\n" +
                        "create file                        ? )))" + "\n" +
                        "show folder structure              tree" + "\n" +
                        "copy file                          copy" + "\n" +
                        "compare content of files           fc" + "\n" +
                        "exit");
    }

    @Override
    public File changeCurrentLocation(String path) {
        File file = new File(path);
        return file;


    }


    @Override
    public String find(String keyWord,File file) throws FileNotFoundException{


            String res = "";

            if(file.getName().contains(keyWord)){
                res += file.getAbsolutePath() + "\n";
            }

            if(file.isDirectory()){
                for (File child : file.listFiles()) {
                    String childReturnedRes = find(keyWord, child);
                    res += childReturnedRes;
                }
            }

            return res;


        }

    @Override
    public void dir(String path) {

            File dir = new File(path);

            // validation of input data

            File[] children = dir.listFiles();
            for (File child : children) {
                if(child.isDirectory()){
                    System.out.println("D - " + child.getName());
                } else {
                    System.out.println("F - " + child.getName());
                }
            }

        }


    @Override
    public String type() {
        return null;
    }

    @Override
    public boolean rd() {
        return false;
    }

    @Override
    public File mkDir() {
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

