import com.example.Feline;
import com.example.Lion;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {
    private static final String INCORRECT_MANE = "Неизвестно";
    private static final String INCORRECT_MANE_EXCEPTION_MESSAGE =
            "Используйте допустимые значения пола животного - 'Самец' или 'Самка'";
    private static final String MALE = "Самец";
    private Lion lion;
    @Mock
    private Feline feline;

    @Test
    public void checkIncorrectMane() {
        Throwable thrown = catchThrowable(() -> {
            lion = new Lion(INCORRECT_MANE, feline);
        });
        Assertions.assertThat(thrown).isInstanceOf(Exception.class);
        Assert.assertEquals(INCORRECT_MANE_EXCEPTION_MESSAGE, thrown.getMessage());
    }

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion(MALE, feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        lion = new Lion(MALE, feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

}
