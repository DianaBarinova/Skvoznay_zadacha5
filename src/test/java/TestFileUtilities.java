import com.example.skvoznay_zadacha5.Work.FileUtilities;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
public class TestFileUtilities {
    FileUtilities fileUtilities=new FileUtilities();

@Test
public void Test1(){
   String format=fileUtilities.getFileExtension("file.zip");
    Assert.assertEquals("zip",format);
}
    @Test
    public void Test2(){
        String format=fileUtilities.getFileExtension("file.rar");
        Assert.assertEquals("rar",format);
    }
    @Test
    public void Test3(){
        String format=fileUtilities.getFileExtension("file.txt");
        Assert.assertEquals("txt",format);
    }
    @Test
    public void Test4(){
        String format=fileUtilities.getFileExtension("file.xml");
        Assert.assertEquals("xml",format);
    }
    @Test
    public void Test5(){
        String format=fileUtilities.getFileExtension("file");
        Assert.assertEquals("",format);
    }

}
