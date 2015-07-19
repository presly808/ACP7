package ua.artcode.week4.th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by serhii on 19.07.15.
 */
public class CollectionsTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"Vova","Anrey","Ivan");

        List<String> synchList = Collections.synchronizedList(list);

        List<String> unmodifiedList = Collections.unmodifiableList(list);


    }
}
