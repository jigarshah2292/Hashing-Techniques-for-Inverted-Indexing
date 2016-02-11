/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Jigar
 */
public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        HashMapImpl h=new HashMapImpl();
//        h.new HashedMap();
//        HashMapImpl.HashedMap h1=h.new HashedMap();
        String file[] = new String[4];
        String[] savedFiled = new String[4];
        ReadFile readFile;
        
        HashMap<String, Integer> hm=new HashMap<>();
        Long startTime1 = null;
        for(int i=1;i<=3;i++)
            file[i]="C:/TextFile"+i+".txt";
        
        for(int i=1;i<=3;i++){
            readFile=new ReadFile(file[i]);       
            savedFiled=readFile.saveFile();
        
            System.out.println("File No "+i);
            for(int j=0;j<savedFiled.length;j++){
                System.out.println(savedFiled[j]);
            }
            
            
            
        startTime1=System.nanoTime();
        
        for (String substring : savedFiled){
            String[] data = substring.split(" ");
            for(String key: data){
                Integer freq = hm.get(key);
                if(freq == null) 
                    freq = 1; 
                else
                    freq ++;
            
                hm.put(key, freq);
            }
        }
            System.out.println("----------------------");
      }
        System.out.println(hm);
        
        System.out.println("Hashing with Inverted Index");
        String searchFile="C:/searchFile.txt";
        readFile=new ReadFile(searchFile);       
        savedFiled=readFile.saveFile();
        
        for(int j=0;j<savedFiled.length;j++){
                System.out.println(savedFiled[j]);
            }
        
//        for (String substring : savedFiled){
//            String[] data = substring.split(" ");
//            for(String key: data){
//            if(hm.containsKey(key))
//                System.out.println("Key->"+key+"    value->"+hm.get(key));
//            else
//                System.out.println("Key->"+key+"    value->"+0);                
//            }
//        }
        System.out.println(System.nanoTime()-startTime1+"nanoseconds");
        
        System.out.println("---------------------------------------------");
        
        Long startTime2=System.nanoTime();
        
        System.out.println("Universal Hashing with Linear Probing");
        LinearProbingHashST<String, Integer> HST=new LinearProbingHashST(16);
        int docNo=1;
        for (String substring : savedFiled){
            String[] data = substring.split(" ");
            for(String key: data){
                Integer freq = HST.get(key);
                if(freq == null) 
                    freq = 1; 
                else
                    freq ++;
            
                HST.put(key, freq);
            }
        }
        
//        for (String substring : savedFiled){
//            String[] data = substring.split(" ");
//            for(String key: data){
//            if(HST.contains(key))
//                System.out.println("Key->"+key+"    value->"+HST.get(key));
//            else
//                System.out.println("Key->"+key+"    value->"+0);                
//            }
//        }
        System.out.println(System.nanoTime()-startTime2+"nanoseconds");
        System.out.println("Search Successful");
        for (String substring : savedFiled){
            String[] data = substring.split(" ");
            for(String key: data){
            if(hm.containsKey(key))
                System.out.println("Key->"+key+"    value->"+hm.get(key));
            else
                System.out.println("Key->"+key+"    value->"+0);                
            }
        }
        
        
    }   
    
}
