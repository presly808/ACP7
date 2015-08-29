package ua.artcode.week8.ioc;

/**
 * Created by serhii on 29.08.15.
 */
// client - ServiceLocator -service
public class Client {


    public static void main(String[] args) {
        DependencyInjector dependencyInjector =
                new DependencyInjectorImpl();


        ViewB viewB = new ViewB();


        ViewA viewA = new ViewA();

        dependencyInjector.inject(viewA);
        dependencyInjector.inject(viewB);

        viewA.useService();
    }
}
