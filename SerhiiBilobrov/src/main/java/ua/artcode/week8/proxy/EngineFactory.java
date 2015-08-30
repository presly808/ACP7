package ua.artcode.week8.proxy;

/**
 * Created by serhii on 30.08.15.
 */
public class EngineFactory {
    public static IEngine newEngine() {
        return new EngineProxy(new MachineEngine());
    }
}
