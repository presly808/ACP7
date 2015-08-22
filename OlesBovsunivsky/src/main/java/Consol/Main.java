package Consol;

import java.io.FileNotFoundException;

/**
 * Created by Legion on 06.07.2015.
 */
public class Main {
        public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Write you command -> ");
        MyConsol myConsol = new MyConsol();

            while (myConsol.readConsol()!="exit");
    }
}
