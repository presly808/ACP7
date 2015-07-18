package ua.artcode.ds.hash;

import ua.artcode.test.UnitMapTest;

import java.util.HashMap;

/**
 * Created by serhii on 18.07.15.
 */
public class RunUnitHashMapTest {


    public static void main(String[] args) {
        UnitMapTest unitMapTest = new UnitMapTest(new HashMap<>());
        unitMapTest.runAll();
    }
}
