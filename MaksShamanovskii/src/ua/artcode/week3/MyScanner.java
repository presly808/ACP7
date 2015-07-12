package ua.artcode.week3;

import java.io.IOException;
import java.io.Reader;
import java.util.InputMismatchException;

public class MyScanner {
    private Reader reader;
    private String buf;
    private int count = 0;

    public MyScanner(Reader reader){
        this.reader = reader;
    }

    public MyScanner(String line){
        buf = line;
    }

    public String nextLine(){
        if(buf == null){
            StringBuilder builder = new StringBuilder();
            try {
                int k = 0;
                while((k = reader.read()) != -1) {
                    builder.append((char)k);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return builder.toString();
        }
        return buf;
    }

    public String next(){
        if(buf == null){
            StringBuilder builder = new StringBuilder();
            try {
                int k = 0;
                while((char) (k = reader.read()) == ' ') {
                    builder.append((char)k);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return builder.toString();
        }
        String[] lines = buf.split(" ");
        return lines[count++];
    }

    public int nextInt() {
        if (buf == null) {
            StringBuilder builder = new StringBuilder();
            try {
                int k = 0;
                while ((char) (k = reader.read()) == ' ') {
                    builder.append((char) k);
                }
                return Integer.parseInt(builder.toString());
            } catch (NumberFormatException e){
                throw new InputMismatchException(e.getMessage());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        String[] lines = buf.split(" ");
        try {
            return Integer.parseInt(lines[count++]);
        }catch (NumberFormatException e){
            throw new InputMismatchException(e.getMessage());
        }
    }

}
