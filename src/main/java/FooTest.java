import org.junit.Assert;
import org.junit.Test;

public class FooTest {

    @Test
    public void testToString() {
        String expected = "Test";
        Foo foo = new Foo(expected);
        Assert.assertEquals(expected, foo.toString());
    }
}