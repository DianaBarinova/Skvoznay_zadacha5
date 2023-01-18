package com.example.skvoznay_zadacha5.Work.Parsing;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.*;
import java.security.GeneralSecurityException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Xml {

    public String read(String FileName) throws GeneralSecurityException, IOException, ParserConfigurationException, SAXException {
        String result="";
        File file = new File(FileName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            Document doc = null;
            doc = dbf.newDocumentBuilder().parse(file);
            NodeList nodeList = doc.getElementsByTagName("element");
            for(int i = 0; i < nodeList.getLength();i++){
                result=result+nodeList.item(i).getTextContent()+'\n';
            }
            return result;
        }

    public  void writting (String nameFile, String str) throws ParserConfigurationException, IOException, TransformerException {
        String root = "root";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement(root);
        document.appendChild(rootElement);

        String[] res = str.split("\n");
        for (String tmp : res) {

            String element = "element";
            Element em = document.createElement(element);
            em.appendChild(document.createTextNode('\n' + tmp + '\n'));
            rootElement.appendChild(em);
        }

        OutputStream fileOutputStream = new FileOutputStream(nameFile);
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(fileOutputStream);
        transformer.transform(source, result);
        fileOutputStream.close();
    }

}
