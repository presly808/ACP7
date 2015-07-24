package ua.artcode.week3.decor;

/**
 * Created by serhii on 24.07.15.
 */
public class TestDecor {

    public static void main(String[] args) {
        ColorWorkUnit workUnit = new ColorWorkUnit(new BodySceletWorkUnit(null));

        String res = workUnit.doWork();
        System.out.println(res);
    }
}
