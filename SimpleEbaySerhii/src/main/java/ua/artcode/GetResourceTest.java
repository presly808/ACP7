package ua.artcode;

import java.util.Scanner;

/**
 * Created by serhii on 23.08.15.
 */
public class GetResourceTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(
                GetResourceTest.class.
                        getResourceAsStream("/db.properties"));


        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }


    }
}
