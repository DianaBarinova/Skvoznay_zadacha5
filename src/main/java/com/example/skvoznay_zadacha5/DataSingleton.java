package com.example.skvoznay_zadacha5;

public class DataSingleton {
    private  static  final DataSingleton instance=new DataSingleton();

    private String fileName;
    private DataSingleton(){}

    public static DataSingleton getInstance(){
        return instance;
    }
    public String getFileName(){
        return fileName;
    }
    public void setFileName(String fileName){
        this.fileName=fileName;
    }
}
