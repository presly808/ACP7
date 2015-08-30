package ua.artcode.week8.proxy;

/**
 * Created by serhii on 30.08.15.
 */
public class Client {

    public static void main(String[] args) {

        IEngine engine = EngineFactory.newEngine();;



        int pow = engine.start(1);
        String res = engine.stop(345);

        System.out.printf("pow %d, info %s", pow, res);

    }
}
