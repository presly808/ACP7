package ua.artcode.week4.th.homework.search;

import java.io.File;
import java.util.ArrayList;

public class SearchOptions {
    private String name;

    public SearchOptions(String name) {
        this.name = name;
    }

    private File search(ArrayList<File> catalog){

        for (int i = 0; i < catalog.size(); i++) {
            if(catalog.get(i).equals(name)) {
                File found = catalog.get(i);
                return found;
            }

        }

        return null;
    }
}
