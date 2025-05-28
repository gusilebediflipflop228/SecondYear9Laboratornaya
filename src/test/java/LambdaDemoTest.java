import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LambdaDemoTest {

    @Test
    public void testStringLengthForNonEmptyString() {
        assertEquals(5, LambdaDemo.stringLength.apply("Hello"));
        assertEquals(7, LambdaDemo.stringLength.apply("Timofey"));
    }




    @Test
    public void testFirstCharForNonEmptyStringOrNull() {
        assertEquals(Character.valueOf('H'), LambdaDemo.firstChar.apply("Hello"));
        assertEquals(Character.valueOf('T'), LambdaDemo.firstChar.apply("Timofey"));
        assertNull(LambdaDemo.firstChar.apply(""));
        assertNull(LambdaDemo.firstChar.apply(null));
    }




    @Test
    public void testNoSpace() {
        assertTrue(LambdaDemo.noSpace.test("Hello"));
        assertTrue(LambdaDemo.noSpace.test("Timofey"));
        assertTrue(LambdaDemo.noSpace.test(""));
        assertFalse(LambdaDemo.noSpace.test(" Hello"));
    }




    @Test
    public void testWordCount() {
        assertEquals(3, LambdaDemo.wordCount.apply("one,two,three"));
        assertEquals(5, LambdaDemo.wordCount.apply("a,b,c,d,e"));
        assertEquals(2, LambdaDemo.wordCount.apply(" hello ,world "));
        assertEquals(1, LambdaDemo.wordCount.apply("Hello"));
        assertEquals(0, LambdaDemo.wordCount.apply(""));
    }




    @Test
    public void testGetAge() {
        Human human1 = new Human("Yurisarov", "Timofey", "Veniaminovich", 22, "Male");
        Human human2 = new Human("Ivanov", "Ivan", "Ivanovich", 52, "Male");
        Human human3 = new Human("Sidorov", "Sidr", "Sidorovich", -5, "Male");
        assertEquals(22, LambdaDemo.getAge.apply(human1));
        assertEquals(52, LambdaDemo.getAge.apply(human2));
        assertEquals(-5, LambdaDemo.getAge.apply(human3));
    }




    @Test
    public void testSameSurname() {
        Human h1 = new Human("Ivanov", "Ivan", "Ivanovich", 20, "Male");
        Human h2 = new Human("Ivanov", "Petr", "Petrovich", 22, "Male");
        Human h3 = new Human("Petrov", "Petr", "Petrovich", 22, "Male");
        assertTrue(LambdaDemo.sameSurname.test(h1, h2));
        assertFalse(LambdaDemo.sameSurname.test(h1,h3));
        assertFalse(LambdaDemo.sameSurname.test(null, null));
    }




    @Test
    public void testGetFIO() {
        Human human1 = new Human("Yurisarov", "Timofey", "Veniaminovich", 22, "Male");
        Human human2 = new Human("Петров", "Петр", null, 25, "Male");
        assertEquals("Yurisarov Timofey Veniaminovich", LambdaDemo.getFIO.apply(human1));
        assertEquals("Петров Петр null", LambdaDemo.getFIO.apply(human2));
    }

}

