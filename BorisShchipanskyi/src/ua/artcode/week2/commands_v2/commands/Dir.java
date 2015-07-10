package ua.artcode.week2.commands_v2.commands;

import ua.artcode.utils.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by boris on 7/10/15.
 */
public class Dir extends Command{
    private final String NAME = "dir";


    @Override
    public void execute() throws IOException {
        if (isHelp(getFilters())) {
            showHelp();
        }else if(getParams().isEmpty() && getFilters().isEmpty()){
            FileUtils.showFolderContent(getFile(), "+");
        } else if(getParams().size() == 1){
            String path = getParams().get(0);
            File file = new File(path);
            if(file.isFile()){
                throw new IOException("cannot execute command: dir  "+path+ " It is a file!!! not a dir!!!" );
            }
            FileUtils.showFolderContent(new File(path), "+");
        }
        else{
            throw new IOException("cannot execute command: "+ NAME);
        }
    }

    @Override
    public void showHelp() {
        System.out.printf("Command: '%s'. Use for getting dir content.\nFor getting content of some other dir enter dir path", NAME);
        System.out.println("Example : dir or dir <dir_path>");
        System.out.println("for help use filter '-h'");

    }

    @Override
    public String getName() {
        return NAME;
    }
}
