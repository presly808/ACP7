package ua.artcode.ClassWork.Week_1.hash;


import ua.artcode.ClassWork.Week_4.test.UnitMapTest;

import java.util.HashMap;

/**
 * Created by serhii on 18.07.15.
 */
public class RunUnitHashMapTest {


    public static void main(String[] args) {
        UnitMapTest unitMapTest = new UnitMapTest(new HashMap<Integer, Object>());
        unitMapTest.runAll();
    }
}
