import com.example.skvoznay_zadacha5.Work.Calculator.CalculatorRegex;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class TestCalculatorRegex {

    CalculatorRegex calculationRegex=new CalculatorRegex();

    @Test
    public void Test1() throws FileNotFoundException {
        String actual=calculationRegex.calculate("2+2");
        Assert.assertEquals("4.0", actual);

    }

    @Test
    public void Test2() throws FileNotFoundException {
        String actual=calculationRegex.calculate("2*3");
        Assert.assertEquals("6.0", actual);

    }

    @Test
    public void Test3() throws FileNotFoundException {
        String actual=calculationRegex.calculate("5-2");
        Assert.assertEquals("3.0", actual);

    }
    @Test
    public void Test4() throws FileNotFoundException {
        String actual=calculationRegex.calculate("10/2");
        Assert.assertEquals("5.0", actual);

    }
}
