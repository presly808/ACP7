package ua.artcode.week2.commands_v2;

import ua.artcode.week2.commands_v2.command_utils.CommandUtils;

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

    public Command(String command) {
        this.command = command;
        mName = CommandUtils.getCommand(command);
        params = CommandUtils.getParams(command);
        filters = CommandUtils.getFilters(command);
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


    protected boolean isHelp(List<String> filters){
        for(String filter: filters){
            if(filter.equals(HRLP_FILTER))
                return true;
        }
        return false;
    }
}
