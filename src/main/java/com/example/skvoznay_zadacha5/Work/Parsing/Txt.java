package com.example.skvoznay_zadacha5.Work.Parsing;
import com.fathzer.soft.javaluator.DoubleEvaluator;

import java.io.*;
import java.util.Scanner;

public class Txt {
    public static String read(String inputFileName) {
        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(inputFileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);
            String string;
            while ((string = reader.readLine()) != null) {
                builder.append(string);
                builder.append("\r\n");
            }
            reader.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return builder.toString();
    }
    public  void writeFile(String outputFileName, String strHandled) {
        try {
            FileOutputStream fos = new FileOutputStream(outputFileName);
            OutputStreamWriter dos = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(dos);
            writer.write(strHandled);
            writer.close();
            dos.close();
            fos.close();
            System.out.println("code that without note has been saved successfully in " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
