package ua.artcode.week8.proxy;

/**
 * Created by serhii on 30.08.15.
 */
public class EngineProxy implements IEngine{

    public static final int MIN_FUEL_LEVEL = 10;
    private static final int MY_KEY = 1212;
    private IEngine target;

    public EngineProxy(IEngine target) {
        this.target = target;
    }

    @Override
    public int start(int fuel) {

        if(fuel < MIN_FUEL_LEVEL){
            return 0;
        }



        return target.start(fuel);
    }

    @Override
    public String stop(int key) {
        if(key != MY_KEY)
            throw new IllegalArgumentException();

        return target.stop(key);
    }
}
