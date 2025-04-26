import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionManeWithParamsTest {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private String sex;
    private boolean hasMane;
    private Lion lion;
    private Feline feline;

    public LionManeWithParamsTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void init() {
        feline = Mockito.mock(Feline.class);
    }

    @Parameterized.Parameters
    public static Object[][] getManeParams() {
        return new Object[][] {
                {MALE, true},
                {FEMALE, false}
        };
    }

    @Test
    public void testDoesHaveMane () throws Exception {
        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(hasMane, actual);
    }

}
