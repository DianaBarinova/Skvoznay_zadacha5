package com.example.skvoznay_zadacha5.Work;

import com.example.skvoznay_zadacha5.Work.Archiver.Archiver;
import com.example.skvoznay_zadacha5.Work.Archiver.Zip;
import com.example.skvoznay_zadacha5.Work.Parsing.Txt;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WorkFile{
    String decision;
        public void Read(String nameFile) throws FileNotFoundException {
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
                        break;
                    case ZIP:
                        Archiver zipFile = new Zip();
                        nameFile = zipFile.unarchiveFile(nameFile);
                        util = fileUtilities.getFileExtension(nameFile);
                        formatFile = FormatFile.START;
                        break;

                    case TXT:
                        Txt txt=new Txt();
                       this.decision=txt.Parsse(nameFile);
                        util = "end";
                        break;
                    case XML:
                        util = "end";
                        break;

                }
            }
        }
        public void write(String nameFile) {
            FileUtilities fileUtilities = new FileUtilities();
            if (fileUtilities.getFileExtension(nameFile).equals("txt")) {
                Txt txt = new Txt();
                txt.writeFile(nameFile, this.decision);
            }
            else if(fileUtilities.getFileExtension(nameFile).equals("xml")){

            }

            packingFile(nameFile);
        }

        public void packingFile(String nameFile)
        {int answer=0;
            Scanner in = new Scanner(System.in);
            while(answer!=4) {
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
                        ;
                        break;
                }
            }

        }

        public void massage(){
            System.out.println("Select an action"+'\n'+
                    "1)file archiving zip"+'\n'
                    +"2)file archiving rar"+'\n'+
                    "3)encode the file"+'\n' +
                    "4)end");
        }
}


