package week2.concole;

import utils.IOUtils;

import java.io.*;


public class MyFileHelper implements FileHelper {
    File file;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String branch = "       ";


    public MyFileHelper(File file) {
        this.file = file;
    }

    @Override
    public String cd() {

        String newConsolePath =  searchFileDir(file,getNewFolderName());

        if (newConsolePath == null) {
            return  null;
        }
        if (!new File(newConsolePath).isDirectory()) {
            System.out.println("This is not a directory!");
            newConsolePath = null;
        }



        return new File(newConsolePath) != null ? new File(newConsolePath).getAbsolutePath() : file.getAbsolutePath();
    }

    @Override
    public void help() {

        readTxtFile("VorobieiYevhen\\resources\\Commands.txt");
    }

    private void readTxtFile(String path) {
        try {
            IOUtils.readFullyByBytes(new FileInputStream(path)); //read bytes and covert them to char
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tree() {

        catalog(file, branch);

    }

    @Override
    public void dir() {

        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {

                    System.out.println("\t<DIR>\t"  + item.getName());

                } else {
                    System.out.println("\t<FILE>\t"  + item.getName());
                }
            }
        }

    }

    @Override
    public boolean mkdir() {

        String folderName = getNewFolderName();

        if (notAllowedName(folderName)) return false;

        if (folderName == null || folderName.equals("")) {
            System.out.println("Folder without name hasn't been created!");
            return  false;
        }
        if (searchFileDir(file, folderName)!= null){
            System.out.println("Folder with current has name already exist");
            return  false;
        }
        return createDir(folderName);


    }

    private boolean createDir(String folderName) {
        File newDir = new File(file.getAbsolutePath() + "\\" + folderName);
        newDir.mkdir();
        System.out.println("Directory " + newDir.getName() + " has been created.");
        return true;
    }

    private String getNewFolderName() {
        System.out.print("Write new directory name: ");
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean mkfile() {

        String fileName = getNewFileName();

        if (notAllowedName(fileName)) return false;


        if (fileName == null || fileName.equals("")) {
            return  false;

        }
        fileName = setFileFormat(fileName);

        if (searchFileDir(file, fileName) != null){
            System.out.println("File with current name has already exist");
            return  false;
        }
        return createFile(fileName);


    }

    private boolean createFile(String fileName) {
        File newFile = new File(file.getAbsolutePath() + "\\" + fileName);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File " + newFile.getName() + " has been created.");
        return true;
    }

    private String setFileFormat(String fileName) {
        System.out.print("Write new file format: ");
        String fileFormat = "";
        try {
            fileFormat = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileName += "." + fileFormat;
        return fileName;
    }

    private String getNewFileName() {
        System.out.print("Write new file name: ");
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean notAllowedName(String fileName) {
        String[] notAllowed = {"+", "=", "[", "]", ":", ";", "«", ".", "/", "?", "\\", "*", "<", ">", "|"};
        for (int i = 0; i < notAllowed.length; i++) {
            if (fileName.contains(notAllowed[i])) {
                System.out.println("Not allowed symbols in file name. File not created.");
                return true;
            }
        }
        return false;
    }

    @Override
    public void find() {
        System.out.print("Write file/directory name: ");
        try {
           search(file, br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void type() {
        String filePath = getFilePath();
        try {
            if (!new File(filePath).isFile()) {
                System.out.println("Can't read, this is not a file!");
            } else if (filePath.endsWith(".txt")) {
                readTxtFile(filePath);
            } else {
                System.out.println("Can't read this file! (Unreadable format)");
            }
        } catch (NullPointerException e) {
            System.out.println("Can't read this file! (Unreadable format)");
        }

    }

    @Override
    public boolean del() {
        String filePath = getFilePath();

            if (filePath == null || !new File(filePath).isFile()) {
                System.out.println("This file doesn't exist!");
                return false;
            }


        String answer = "";

        while (!answer.equalsIgnoreCase("y") || !answer.equalsIgnoreCase("n")) {
            System.out.println("Do you really want to delete this file? (y/n): ");
            try {
                answer = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
                if (answer.equalsIgnoreCase("y")) {
                    new File(filePath).delete();
                    System.out.println("File deleted");
                    return true;
                } else if (answer.equalsIgnoreCase("n")){
                    return false;
                }

        }
        return false;
    }

    @Override
    public boolean rd() {
                String filePath = getFilePath();

                if (filePath == null || !new File(filePath).isDirectory()) {
                    System.out.println("This directory doesn't exist!");
                    return false;
                }
                String answer = "";

                while (!answer.equalsIgnoreCase("y") || !answer.equalsIgnoreCase("n")) {
                    System.out.println("All files will be lost!\nDo you really want to delete this directory? (y/n): ");
                    try {
                        answer = br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (answer.equalsIgnoreCase("y")) {
                        if (new File(filePath).listFiles().length == 0) {
                            new File(filePath).delete();
                        } else {
                            delAllFiles(new File(filePath));
                            new File(filePath).delete();
                        }
                        System.out.println("Directory deleted");
                        return true;
                    } else if (answer.equalsIgnoreCase("n")){
                        return false;
                    }

                }
                return  false;




    }

    private String getFilePath() {
        System.out.print("Write filename: ");
        String filePath = null;
        try {
            filePath = searchFileDir(file, br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    private static void catalog (File file, String branch) {
        branch += branch;
        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(branch + "|----------" + item.getAbsolutePath());
                    catalog(item, branch);
                }
            }
        }
    }

    private  void search (File file, String fileName) {
        for (File item : file.listFiles()) {
             if (item.isDirectory() && item.getName().contains(fileName)) {
                  search(item, fileName);
                  System.out.println("Directory " + fileName + " location is:  " + item.getAbsolutePath());
             } else if (item.isFile() && item.getName().contains(fileName)){
                  System.out.println("File " + fileName + " location is:  " + item.getAbsolutePath());
             } else if (item.isDirectory()) {
                  search(item, fileName);
             }
        }
    }

    private  String searchFileDir (File file, String fileName) {

            for (File item : file.listFiles()) {
                if (item.isDirectory() && item.getName().equals(fileName)) {
                    return item.getAbsolutePath();
                } else if (item.isFile() && item.getName().equals(fileName)){
                    return  item.getAbsolutePath();
                }
            }
        return null;
    }

    private  void delAllFiles (File file) {

        for (File item : file.listFiles()) {

            if (item.isDirectory()) {
               delAllFiles(item);
                item.delete();

            }else {
                item.delete();
            }
        }
    }


}
