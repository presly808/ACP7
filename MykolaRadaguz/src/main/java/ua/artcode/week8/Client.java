package ua.artcode.week8;

/**
 * Created by pikolo on 29.08.15.
 */
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
