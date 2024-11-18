package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;

    public Controller(){
        currentFile = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt");
    }

    public void setCurrentFile(File currentFile){
        this.currentFile = currentFile;    
    }
    public void setCurrentFile(String filePath){
        this.currentFile = new File(filePath);
    }

    public File getCurrentFile(){
        return currentFile;
    }
    public String getCurrentFilePath(){
        return currentFile.getAbsolutePath();
    }

    public void writeDataOnFile(String data) throws IOException{
        PrintStream ps = new PrintStream(currentFile);
        ps.print(data);
        ps.close();      
    }
}
