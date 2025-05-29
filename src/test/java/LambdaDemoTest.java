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




    @Test
    public void testMakeOlder() {
        Human human1 = new Human("Yurisarov", "Timofey", "Veniaminovich", 22, "Male");
        Human human11 = new Human("Yurisarov", "Timofey", "Veniaminovich", 23, "Male");
        Human human2 = new Human("Ivanov", "Ivan", "Ivanovich", 52, "Male");
        Human human22 = new Human("Ivanov", "Ivan", "Ivanovich", 53, "Male");
        assertEquals(human11, LambdaDemo.makeOlder.apply(human1));
        assertEquals(human22, LambdaDemo.makeOlder.apply(human2));
    }




    @Test
    public void testHumanYoungerThan() {
        Human human1 = new Human("Иванов", "Иван", "Иванович", 20, "Male");
        Human human2 = new Human("Петров", "Пётр", "Петрович", 22, "Male");
        Human human3 = new Human("Сидорова", "Мария", "Ивановна", 25, "Male");
        Human human4 = new Human("Юрисаров", "Тимофей", "Вениаминович", 31, "Male");
        assertTrue(LambdaDemo.humanYoungerThan.test(human1, human2, human3, 30));
        assertFalse(LambdaDemo.humanYoungerThan.test(human1, human2, human4, 30));
    }




    @Test
    public void testPersonAge() {
        LambdaDemo.PersonInfo s = new StudentPersonInfoAdapter(
                    "Юрисаров", "Тимофей", "Вениаминович", 22, "Male", "ОмГУ", "ФЦТК", "Гордое звание айтишник");
        int age = LambdaDemo.personAge.applyAsInt(s); // абстрактный метод интерфейса
        assertEquals(22, age);
    }




    @Test
    public void testSameSurnamePerson() {
        LambdaDemo.PersonInfo s1 = new StudentPersonInfoAdapter(
                "Юрисаров", "Тимофей", "Вениаминович", 22, "Male", "ОмГУ", "ФЦТК", "Гордое звание айтишник");
        LambdaDemo.PersonInfo s2 = new StudentPersonInfoAdapter(
                "Юрисаров", "Алексей", "Вениаминович", 15, "Male", "ОмГУ", "ФЦТК", "Гордое звание айтишник");
        LambdaDemo.PersonInfo s3 = new StudentPersonInfoAdapter(
                "Щербаков", "Тимофей", "Вениаминович", 22, "Male", "ОмГУ", "ФЦТК", "Гордое звание айтишник");
        assertTrue(LambdaDemo.sameSurnamePerson.test(s1, s2));
        assertFalse(LambdaDemo.sameSurnamePerson.test(s1, s3));
    }




    @Test
    public void testPersonFIO() {
        LambdaDemo.PersonInfo p1 = new HumanPersonInfoAdapter("Иванов", "Иван", "Иванович", 30, "Male");
        LambdaDemo.PersonInfo p2 = new HumanPersonInfoAdapter("Сидоров", null, "Александрович", 40, "Male");
        assertEquals("Иванов Иван Иванович", LambdaDemo.personFIO.apply(p1));
    assertEquals("Сидоров null Александрович", LambdaDemo.personFIO.apply(p2));
    }
}



