package week4.threads.home.task.file.search;

import java.io.File;
import java.util.concurrent.Callable;

/**
 * Created by Пользователь on 23.07.2015.
 */
public class Model {

    public static class MyThreadFileCount implements Callable<Integer> {
        public Integer counter;
        private FileSearch fileSearch1;
        private String fileName; //с расширением
        private File searchingDirectory1;


        public MyThreadFileCount(FileSearch fileSearch1) {
            this.fileSearch1 = fileSearch1;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public void setSearchingDirectory1(File searchingDirectory1) {
            this.searchingDirectory1 = searchingDirectory1;
        }




        @Override
        public Integer call() throws Exception {
            counter += fileSearch1.searchCount(fileName, searchingDirectory1);

            return counter;
        }
    }
}