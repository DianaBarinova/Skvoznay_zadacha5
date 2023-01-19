package com.example.skvoznay_zadacha5.Work.Calculator;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import java.io.FileNotFoundException;

public class Calculation {

    public  String  Parsse(String decision) throws FileNotFoundException {
        DoubleEvaluator eval = new DoubleEvaluator();
        String result="";
        //    Double result = eval.evaluate(primer);
        String stringExamples= decision;
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
}
