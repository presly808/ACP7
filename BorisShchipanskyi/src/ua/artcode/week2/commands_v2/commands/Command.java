package ua.artcode.week2.commands_v2.commands;

import ua.artcode.week2.commands_v2.command_utils.CommandUtils;

import java.io.File;
import java.util.List;

/**
 * Created by boris on 7/9/15.
 */
public abstract class Command implements ICommand{
    private String command;
    private String mName;
    private List<String> params;
    private List<String> filters;
    private final String HRLP_FILTER = "-h";
    private File file;

    public Command() {

    }

    public Command(String command) {
        setCommand(command);
    }
    public void init(){
        mName = CommandUtils.getCommand(command);
        params = CommandUtils.getParams(command);
        filters = CommandUtils.getFilters(command);
    }

    public void setCommand(String command){
        this.command = command;
        init();
    }

    public List<String> getFilters() {
        return filters;
    }

    public String getmName() {
        return mName;
    }

    public List<String> getParams() {
        return params;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    protected boolean isHelp(List<String> filters){
        for(String filter: filters){
            if(filter.equals(HRLP_FILTER))
                return true;
        }
        return false;
    }
}
