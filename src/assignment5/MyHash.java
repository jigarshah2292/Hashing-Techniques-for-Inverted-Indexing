/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 *
 * @author Jigar
 */
public class MyHash {
    int size;
    Object ht[];
    public MyHash(int size){
        this.size=size;
        this.ht=new String[size];
        for(int i=0;i<ht.length;i++){
            ht[i]="-1";
        }
    }
    public void store(String key, int docNo, int freq){       
        int address;
        address=moduloDivision(key);
        if (!ht[address].equals("-1")){
            address=linearProbe(address);
        }
        Value v=new Value();
        v.setKey(key);
        v.setFreqAndDoc(freq, docNo);
        ht[address]=v;       
    }
    
    public int retrive(String key){
        int address;
        address=moduloDivision(key);
        if (!ht[address].equals("-1")){
            Value v=(Value)ht[address];
            int temp[]=v.getFreqAndDoc();
            
        }
    }
    
    public int moduloDivision(String key){
        int address;
        address=universalHash(key.hashCode()) % ht.length + 1;
        if(address==ht.length){
            return 0;
        }          
        else{
            return address;
        }
    }
    
    public int linearProbe(int address){
        while(!ht[address].equals("-1")){
            address++;
            if(address==ht.length){
                address=0;
            }
        }
        return address;
    }
    
    public int universalHash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        int hashCode = h ^ (h >>> 7) ^ (h >>> 4);
        return hashCode;
    }
    
}
