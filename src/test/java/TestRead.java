import com.example.skvoznay_zadacha5.Work.Archiver.Zip;
import com.example.skvoznay_zadacha5.Work.Parsing.Txt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRead {
    String expected="50-37-2^4\n" + "89+100-56*8\n" + "78-29";

    @Test
    public void TestTxt(){
        Txt txt = new Txt();
        try {
            String actual = txt.Parsse("src/TestFiles/inputTestTxt.txt");
            assertEquals(expected,actual);

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    }
    @Test
    public void TestXml(){
        Txt txt = new Txt();
        try {
            String actual = txt.Parsse("src/TestFiles/inputTestXml.xml");
            assertEquals(expected,actual);

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    }
}
