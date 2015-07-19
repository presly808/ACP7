package ua.artcode;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String text = "Слова мои верные верные";

        String[] mas = text.split(" ");
        for (int i = 0; i < mas.length - 1; i++) {
            if(mas[i].equals(mas[i+1])){
                mas[i] = "";
            }
        }

    }
}
