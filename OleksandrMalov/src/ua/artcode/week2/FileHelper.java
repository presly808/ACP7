package ua.artcode.week2;

/**
 * Created by Олександр on 08.07.2015.
 */
public class FileHelper {
    public static void main(String[] args) {
        help();
        cd();
    }

    private static void help(){
        System.out.print(
                "       - show all available commands        help\n" +
                "       - changeCurrentLocation              cd\n" +
                "       - find file(dir)                     find\n" +
                "       - show directoryContent              dir\n" +
                "       - show file (content)                type\n" +
                "       - delete file or dir                 del , rd\n" +
                "       - create dir                         mkdir\n" +
                "       - show folder structure              tree\n" +
                "       - copy file                          copy\n" +
                "       - compare content of files           fc\n"
        );
    }

    private static void cd(){



    }
}
