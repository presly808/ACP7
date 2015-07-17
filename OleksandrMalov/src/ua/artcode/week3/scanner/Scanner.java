package ua.artcode.week3.scanner;


import java.io.*;
import java.util.*;

public class Scanner implements IScanner {

    private static int endOfInput = -1;           
    private static String delimiter = " \t\f\r\n";
    private static String badInputExceptionMessage ="bad input ";

    private PushbackReader pushbackReader;
    private LineNumberReader lineNumberReader;
    private IOException ioException = null;
    private StringBuffer previousNextBuffer = new StringBuffer();
    private int radix = 10;
    private boolean closed = false;

    private void setIoException(IOException ioe) {
        ioException = ioe;
        ioe.printStackTrace();
    }

    private void undoNext() {
        if (previousNextBuffer.length() > 0) {
            try {
                pushbackReader.unread(previousNextBuffer.toString().toCharArray());
            } catch (IOException ioe) {
                setIoException(ioe);
            }
        }
    }

    private boolean _isWhitespace(int chr) {
        return delimiter.indexOf((char)chr) >= 0;
    }

    private int nextChar() {
        if (closed)
            throw new IllegalStateException();
        try {
            return pushbackReader.read();
        } catch (IOException ioe) {
            setIoException(ioe);
            return endOfInput;
        }
    }

    private boolean hasNextChar() {
        try {
            int chr = nextChar();
            if (chr == endOfInput)
                return false;
            unread(chr);
            return true;
        } catch (IOException ioe) {
            setIoException(ioe);
            return false;
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

    private void unread(int chr) throws IOException {
        pushbackReader.unread(chr);
    }


    private int peek() throws IOException {
        int peekChar = nextChar();
        unread(peekChar);
        return peekChar;
    }

    private NoSuchElementException getNoSuchElementException() {
        int lineNum = lineNumberReader.getLineNumber();
        return new NoSuchElementException(badInputExceptionMessage + lineNum);
    }

    @Override
    public String next(){
        previousNextBuffer.setLength(0);
        try{
            while (hasNextChar() && _isWhitespace(peek())) {
                previousNextBuffer.append((char) nextChar());
            }
            StringBuffer result = new StringBuffer();
            while (hasNextChar() && !_isWhitespace(peek())) {
                char chr = (char) nextChar();
                result.append(chr);
                previousNextBuffer.append(chr);
            }
            if (result.length() == 0)
                throw getNoSuchElementException();
            return result.toString();
        } catch (IOException ioe){
            setIoException(ioe);
            return null;
        }
    }

    @Override
    public int nextInt(int radix) {
        return 0;
    }

    @Override
    public String nextLine() {
        if (!hasNextLine())
            throw getNoSuchElementException();
        StringBuffer result = new StringBuffer();
        while (hasNextChar()) {
            char next = (char)nextChar();
            if (next == '\n')
                break;
            else if (next == '\r')
                continue;
            result.append(next);
        }
        return result.toString();
    }

    public boolean hasNextLine() {
        return hasNextChar();
    }

    @Override
    public boolean hasNext() {
        try {
            next();
            return true;
        } catch (NoSuchElementException nsee) {
            return false;
        } finally {
            undoNext();
        }
    }

    @Override
    public boolean hasNextInt(int radix) {
        try {
            nextInt(radix);
            return true;
        } catch (NoSuchElementException nsee) {
            return false;
        } finally {
            undoNext();
        }
    }

    @Override
    public void useDelimiter(String delimeter) {

    }

    @Override
    public void close() {
        try {
            pushbackReader.close();
            closed = true;
        } catch (IOException ioe) {
            setIoException(ioe);
        }
    }
}
