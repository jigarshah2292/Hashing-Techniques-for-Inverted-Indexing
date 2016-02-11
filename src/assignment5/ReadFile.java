/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Jigar
 */
public class ReadFile {
    private String path;
    FileReader fr;
    BufferedReader textReader;
    
    public ReadFile(String file_path) throws FileNotFoundException{
        path=file_path;
        fr=new FileReader(path);
        textReader=new BufferedReader(fr);
    }
    
    public String[] saveFile() throws FileNotFoundException, IOException{
        
        int numberOfLines = readLines();
        String[ ] textData = new String[numberOfLines];
        
        for (int i=0; i < numberOfLines; i++) {
            textData[ i ] = textReader.readLine();
        }
        textReader.close( );
        return textData;
        
    }
    
    public int readLines() throws FileNotFoundException, IOException{
        FileReader fr=new FileReader(path);
        BufferedReader textReader=new BufferedReader(fr);
        
        String aLine;
        int numberOfLines=0;
        
        while((aLine=textReader.readLine())!=null){
            numberOfLines++;
        }
        textReader.close();
        return numberOfLines;
    }
    
}
