import com.example.skvoznay_zadacha5.Work.Calculator.Calculation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class TestCalculation {

    Calculation calcul = new Calculation();

    @Test
    public void Test1() throws FileNotFoundException {
        String actual=calcul.Parsse("2+2\n" + "3+8\n" + "3+3\n");
        Assert.assertEquals("4.0\n" +
                "11.0\n" +
                "6.0\n", actual);

    }
    @Test
    public void Test2() throws FileNotFoundException {
        String actual=calcul.Parsse("100/0\n");
        Assert.assertEquals("Infinity\n", actual);

    }
    @Test
    public void Test3() throws FileNotFoundException {
        String actual=calcul.Parsse("100/0\n");
        Assert.assertEquals("Infinity\n", actual);

    }
    @Test
    public void Test4() throws FileNotFoundException {
        String actual=calcul.Parsse("sin(5)\n");
        Assert.assertEquals("-0.9589242746631385\n", actual);

    }
    @Test
    public void Test5() throws FileNotFoundException {
        String actual=calcul.Parsse("(2+3*5^2+72/2)/10\n");
        Assert.assertEquals("11.3\n", actual);

    }
}