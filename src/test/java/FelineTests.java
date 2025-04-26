import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {
    @Spy
    Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testResultOfEatMeat() throws Exception {
        List<String> actualValue = feline.eatMeat();
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), actualValue);
    }

    @Test
    public void testGetFamily(){
        String actualValue = feline.getFamily();
        Assert.assertEquals("Кошачьи", actualValue);
    }

    @Test
    public void testGetKittens() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensWithParam() {
        feline.getKittens(2);
        Mockito.verify(feline).getKittens(2);
    }
}