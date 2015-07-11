package ua.artcode.week2.commands_v2.commands;

import ua.artcode.utils.FileUtils;

import java.io.IOException;

/**
 * Created by boris on 7/10/15.
 */
public class Find extends Command{
    private final String NAME = "find";

    @Override
    public void execute() throws IOException {
        if (isHelp(getFilters())) {
            showHelp();
        }else if(getParams().size() != 0){
            String keyWord = getParams().get(0);
            String result = FileUtils.findByNameWithReq(getFile(), keyWord);
            if(result.length() > 0){
                System.out.println("Find next files: \n" + result);
            }else
                System.out.println("no file find!");
        }else{
            throw new IOException("Command: "+ NAME +" Get Incorrect params!!!");
        }
    }

    @Override
    public void showHelp() {
        System.out.printf("Command: '%s' use for find file. For start point use location dir.\n", NAME);
        System.out.println("Example : find <someFile>");
        System.out.println("for help use filter '-h'");
    }

    @Override
    public String getName() {
        return NAME;
    }
}
