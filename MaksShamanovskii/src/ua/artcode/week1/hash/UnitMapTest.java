package ua.artcode.week1.hash;

import java.util.Map;

public class UnitMapTest {

    private Map map;

    public UnitMapTest(Map map) {
        this.map = map;
    }

    public void runAll(){
        putSimpleTest();
        removeSimpleTest();
    }

    public void putSimpleTest(){
        Object expected = 2;
        map.put(1, expected);
        Object actual = map.get(1);
        System.out.println(expected.equals(actual));
    }

    public void removeSimpleTest(){
        map.remove(1);
        System.out.println(map.isEmpty());
    }

}
