package ua.artcode.test;

import ua.artcode.utils.io.IOUtils;

import java.io.File;

/**
 * Created by serhii on 21.08.15.
 */
public class TestFileSearcher {

    public static void main(String[] args) {
        String res = IOUtils.findByNameWithRes(new File("/home/serhii/dev/IdeaProjects/ACP7"),"Client");
    }
}
