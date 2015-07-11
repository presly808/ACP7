package ua.artcode.week2.commands_v2.commands;

import ua.artcode.utils.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by boris on 7/10/15.
 */
public class Type  extends Command {
    private final String NAME = "type";

    @Override
    public void execute() throws IOException {
        if (isHelp(getFilters())) {
            showHelp();
        }if(getParams().size() != 0){
            String filePath = getParams().get(0);
            File file = new File(filePath);
            if(file.isDirectory()){
                throw new IOException("Cannot execute type. "+  filePath + " it is a dir, not a file!");
            }
            String fileContent = FileUtils.showFileContent(file);
            System.out.printf("Content of file : %s \n%s", filePath, fileContent);
        }else
            throw new IOException("Not file path!");

    }

    @Override
    public void showHelp() {
        System.out.printf("Command: '%s'. Use for getting file content.\n", NAME);
        System.out.println("Example : type  <file_path>");
        System.out.println("for help use filter '-h'");
    }

    @Override
    public String getName() {
        return NAME;
    }
}
