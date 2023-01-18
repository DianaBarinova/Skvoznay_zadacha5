import com.example.skvoznay_zadacha5.Work.Archiver.Zip;
import com.example.skvoznay_zadacha5.Work.Parsing.Txt;
import com.example.skvoznay_zadacha5.Work.Parsing.Xml;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWtite {
    String expected="10.0\n" + "5.0\n" + "15.0\n";

    @Test
    public void TestWriteTxt() throws IOException {
        Txt txt= new Txt();
        txt.writeFile("src/TestFiles/OutputTestTxt.txt", expected);
       String actual=txt.read("src/TestFiles/OutputTestTxt.txt");
        assertEquals(expected,actual);
    }
    @Test
    public void TestWriteXml() throws IOException, ParserConfigurationException, TransformerException, GeneralSecurityException, SAXException {
        Xml xml=new Xml();
        xml.writting("src/TestFiles/OutputTestXml.xml", expected);
        String actual=xml.read("src/TestFiles/OutputTestXml.xml");
        assertEquals(expected,actual);
    }
}
