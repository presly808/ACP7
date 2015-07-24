package ua.artcode.week4.th.homework.search;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;


public class SearchWithoutRecurtion2 implements FilenameFilter {

    private String mask;
    public SearchWithoutRecurtion2(String mask) {
        this.mask = mask;
    }

    public boolean accept(File dir, String name) {
        File f = new File (name);
        if (f.getName().contains(mask)){
            return true;
        }
        else {return false;}
    }


    public static void main (String args []){

        String Path = args[0];
        String mask = args[1];
        // Integer depth_temp =Integer.valueOf(args[2]);
        //int depth = depth_temp.intValue();
        File rootPath = new File (Path);
        if (rootPath.isDirectory()){
            ArrayList <File> listt = new ArrayList  <File> ();
            listt.add(rootPath);
            do {
                for (int i=0; i<listt.size(); i++){
                    if (listt.get(i).isDirectory()){
                        listt.addAll(Arrays.asList(listt.get(i).listFiles()));
                    }
                }
            }
            while (listt.isEmpty());
            File [] all = listt.toArray(new File[listt.size()]);
            for (int i=0; i<all.length; i++){
                if (all[i].isDirectory()){
                    File [] folderlist = all[i].listFiles(new SearchWithoutRecurtion2(mask));
                    for (int j=0; j<folderlist.length; j++){
                        System.out.println(folderlist[j]);
                    }
                }
            }
        }
    }
}