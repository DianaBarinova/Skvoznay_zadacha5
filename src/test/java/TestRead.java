import com.example.skvoznay_zadacha5.Work.Archiver.Zip;
import com.example.skvoznay_zadacha5.Work.Parsing.Txt;
import com.example.skvoznay_zadacha5.Work.Parsing.Xml;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRead {
    String expected="50-37-2^4\n" + "89+100-56*8\n" + "78-29";

    @Test
    public void TestTxt(){
        Txt txt = new Txt();
        try {
            String actual = txt.read("src/TestFiles/inputTestTxt.txt");
            assertEquals(expected,actual);

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    }
    @Test
    public void TestXml(){
        Xml xml=new Xml();
        try {
            String actual = xml.read("src/TestFiles/inputTestXml.xml");
            assertEquals(expected,actual);

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    }
}
