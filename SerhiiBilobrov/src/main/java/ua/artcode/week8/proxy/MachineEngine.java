package ua.artcode.week8.proxy;

/**
 * Created by serhii on 30.08.15.
 */
public class MachineEngine implements IEngine {


    @Override
    public int start(int fuel) {
        return 50;
    }

    @Override
    public String stop(int key) {
        return key == 1212 ? "stop" : "problem";
    }
}
