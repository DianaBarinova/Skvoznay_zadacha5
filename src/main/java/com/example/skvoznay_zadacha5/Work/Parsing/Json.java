package com.example.skvoznay_zadacha5.Work.Parsing;

import java.io.*;
import java.security.GeneralSecurityException;
import com.google.gson.Gson;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class Json {
    public String read(String nameFile) throws IOException, SAXException, ParserConfigurationException {
            BufferedReader br = new BufferedReader(new FileReader(nameFile));
            nameFile = new Gson().fromJson(br, String.class);
            br.close();
            return nameFile;
        }

    public void writing(String namrFile, String str) throws IOException {
            FileWriter fw = new FileWriter(namrFile);
            fw.write(new Gson().toJson(str));
            fw.close();
        }

    }
