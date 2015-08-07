package week4.threads.home.task.file.search;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by Пользователь on 24.07.2015.
 */
public class View {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите файл поиска с расширением");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        System.out.println("Введите первую папку поиска");
        Scanner sc1 = new Scanner(System.in);
        String pathName1 = sc1.nextLine();
        System.out.println("Введите вторую папку поиска");
        Scanner sc2 = new Scanner(System.in);
        String pathName2 = sc2.nextLine();
        FileSearch fileSearch = new FileSearch(fileName, new File(pathName1));
        FileSearch fileSearch1 = new FileSearch(fileName, new File(pathName2));
        ExecutorService ex = Executors.newFixedThreadPool(2);

        Callable<Integer> callable = new Model.MyThreadFileCount(fileSearch);
        Callable<Integer> callable1 = new Model.MyThreadFileCount(fileSearch1);



        Future<Integer> s = ex.submit(callable);

        Future<Integer> s1 = ex.submit(callable1);

        try {
            int i = s.get();//+s1.get();
            System.out.println("Количество искомых файлов в папке ="+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }
}
