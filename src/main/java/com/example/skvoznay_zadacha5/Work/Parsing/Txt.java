package com.example.skvoznay_zadacha5.Work.Parsing;
import com.fathzer.soft.javaluator.DoubleEvaluator;

import java.io.*;
import java.util.Scanner;

public class Txt {

    public static String  Parsse(String name) throws FileNotFoundException {
        DoubleEvaluator eval = new DoubleEvaluator();
        String result="";
    //    Double result = eval.evaluate(primer);
        String stringExamples= readFile(name);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stringExamples.length(); ++i) {
            char c = stringExamples.charAt(i);
            if(c!='\n'){
                builder.append(c);
            }
            else{
              result=result+eval.evaluate(builder.toString()).toString()+'\n';
              builder.delete(0,builder.length());
            }
        }

return result;

    }
    public static String readFile(String inputFileName) {
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
    public static void writeFile(String outputFileName, String strHandled) {
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
