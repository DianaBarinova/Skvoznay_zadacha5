package com.example.skvoznay_zadacha5.Work;

import com.example.skvoznay_zadacha5.Work.Archiver.Archiver;
import com.example.skvoznay_zadacha5.Work.Archiver.Jar;
import com.example.skvoznay_zadacha5.Work.Archiver.Rar;
import com.example.skvoznay_zadacha5.Work.Archiver.Zip;
import com.example.skvoznay_zadacha5.Work.Calculator.Calculation;
import com.example.skvoznay_zadacha5.Work.Encryptor.Encryptor;
import com.example.skvoznay_zadacha5.Work.Parsing.Json;
import com.example.skvoznay_zadacha5.Work.Parsing.Txt;
import com.example.skvoznay_zadacha5.Work.Parsing.Xml;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;

public class WorkFile{
    String decision;
    String result;
    String outputFile;


        public void Read(String nameFile) throws IOException, GeneralSecurityException, ParserConfigurationException, SAXException {
            FileUtilities fileUtilities=new FileUtilities();
            FormatFile formatFile = FormatFile.START;
            String util=fileUtilities.getFileExtension(nameFile);

            while(!util.equals("end")) {
                switch (formatFile) {
                    case START:
                        if (util.equals("zip")) {
                            formatFile = FormatFile.ZIP;
                        } else if (util.equals("txt")) {
                            formatFile = FormatFile.TXT;
                        } else if (util.equals("xml")) {
                            formatFile = FormatFile.XML;
                        } else if (util.equals("")) {
                            formatFile = FormatFile.EMPTY;
                        }
                        else if(util.equals("encrypted")){
                            formatFile=FormatFile.ENCRYPTED;
                        }
                        else if(util.equals("json")){
                            formatFile=FormatFile.JSON;
                        }
                        else if(util.equals("rar")){
                            formatFile=FormatFile.RAR;
                        }
                        else if(util.equals("jar")){
                            formatFile=FormatFile.JAR;
                        }
                        break;
                    case ZIP:
                        Archiver zipFile = new Zip();
                        nameFile = zipFile.unarchiveFile(nameFile);
                        util = fileUtilities.getFileExtension(nameFile);
                        formatFile = FormatFile.START;
                        break;
                    case RAR:
                        Archiver rar=new Rar();
                        nameFile = rar.unarchiveFile(nameFile);
                        util = fileUtilities.getFileExtension(nameFile);
                        formatFile = FormatFile.START;
                        break;

                    case JAR:
                        Archiver jar=new Jar();
                        nameFile = jar.unarchiveFile(nameFile);
                        util = fileUtilities.getFileExtension(nameFile);
                        formatFile = FormatFile.START;
                        break;

                    case ENCRYPTED:
                        File file=new File(nameFile);
                        Encryptor encryptor=new Encryptor();
                        file =encryptor.encoding(file, true);
                        nameFile=file.getName();
                        formatFile = FormatFile.START;
                        break;

                    case TXT:
                        Txt txt=new Txt();
                       this.decision=txt.read(nameFile);
                        util = "end";
                        break;
                    case XML:
                        Xml xml=new Xml();
                        this.decision=xml.read(nameFile);
                        util = "end";
                        break;
                    case JSON:
                        Json json = new Json();
                        this.decision=json.read(nameFile);
                        util="end";
                        break;

                }
            }
        }

        public void parse() throws FileNotFoundException {
            Calculation calculation=new Calculation();
            this.result=calculation.Parsse(this.decision);
        }
        public void write(String nameFile) throws ParserConfigurationException, IOException, TransformerException {
         parse();
            FileUtilities fileUtilities = new FileUtilities();
            if (fileUtilities.getFileExtension(nameFile).equals("txt")) {
                Txt txt = new Txt();
                txt.writeFile(nameFile, this.result);
            }
            else if(fileUtilities.getFileExtension(nameFile).equals("xml")){
             Xml xml = new Xml();
             xml.writting(nameFile, this.result);

            }
            else if(fileUtilities.getFileExtension(nameFile).equals("json")){
                Json json= new Json();
                json.writing(this.result, nameFile);
            }
this.outputFile=nameFile;
        //    packingFile(nameFile);
        }

        public void packingFile(String nameFile)
        {int answer=0;
            Scanner in = new Scanner(System.in);
            while(answer!=5) {
                massage();
                answer=in.nextInt();
                switch (answer) {
                    case (1):
Archiver zip=new Zip();
nameFile=zip.archiveFile(nameFile);
                        break;
                    case (2):

                        break;
                    case (3):
                        File file=new File(nameFile);
                        boolean decrypt;
                        Encryptor encryptor=new Encryptor();
                        file =encryptor.encoding(file, decrypt = false);
                        nameFile=file.getName();
                        break;
                    case (4):
                        Archiver jar=new Jar();
                        nameFile=jar.archiveFile(nameFile);
                }
            }

        }

        public void massage(){
            System.out.println("Select an action"+'\n'+
                    "1)file archiving zip"+'\n'
                    +"2)file archiving rar"+'\n'+
                    "3)encode the file"+'\n' +
                    "4)jar\n"+
                    "5)end");
        }

    public String getDecision() {
        return decision;
    }
    public String getResult() {
        return result;
    }

    public String getOutputFile() {
        return outputFile;
    }
}


