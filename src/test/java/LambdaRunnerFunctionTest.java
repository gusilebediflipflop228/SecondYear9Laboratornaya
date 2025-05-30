import Classes.LambdaRunner;
import org.junit.Test;

import java.util.function.*;

import static org.junit.Assert.*;

public class LambdaRunnerFunctionTest {

    @Test
    public void testRun_StringLength() {
        Function<String, Integer> lengthFunc = String::length;
        int result = LambdaRunner.run(lengthFunc, "hello");
        assertEquals(5, result);
    }

    @Test
    public void testRun_SquareInteger() {
        Function<Integer, Integer> square = x -> x * x;
        int result = LambdaRunner.run(square, 7);
        assertEquals(49, result);
    }



    @Test
    public void testRun_AddIntegers() {
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        int result = LambdaRunner.run(add, 2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testRun_ConcatStrings() {
        BiFunction<String, String, String> concat = String::concat;
        String result = LambdaRunner.run(concat, "Hello, ", "world!");
        assertEquals("Hello, world!", result);
    }

    @Test
    public void testRun_CompareLengths() {
        BiFunction<String, String, Boolean> sameLength = (a, b) -> a.length() == b.length();
        boolean result = LambdaRunner.run(sameLength, "cat", "dog");
        assertTrue(result);
    }




    @Test
    public void testRun_SimpleString() {
        Supplier<String> supplier = () -> "hello";
        String result = LambdaRunner.run(supplier);
        assertEquals("hello", result);
    }

    @Test
    public void testRun_SupplierCalculatesValue() {
        Supplier<Integer> supplier = () -> 2 * 21;
        int result = LambdaRunner.run(supplier);
        assertEquals(42, result);
    }




    @Test
    public void testRun_ConsumerWithString() {
        StringBuilder sb = new StringBuilder();
        Consumer<String> appendHello = s -> sb.append("Hello, ").append(s);
        LambdaRunner.run(appendHello, "world!");
        assertEquals("Hello, world!", sb.toString());
    }




    @Test
    public void testRun_BiConsumer_AppendsStrings() {
        StringBuilder sb = new StringBuilder();
        BiConsumer<String, String> append = (a, b) -> sb.append(a).append(b);
        LambdaRunner.run(append, "Hello, ", "world!");
        assertEquals("Hello, world!", sb.toString());
    }




    @Test
    public void testRun_IsEven() {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        assertTrue(LambdaRunner.run(isEven, 4));
        assertFalse(LambdaRunner.run(isEven, 3));
    }

    @Test
    public void testRun_CustomObject() {
        class User {
            int age;
            User(int age) { this.age = age; }
        }
        Predicate<User> adult = u -> u != null && u.age >= 18;
        assertTrue(LambdaRunner.run(adult, new User(20)));
        assertFalse(LambdaRunner.run(adult, new User(10)));
        assertFalse(LambdaRunner.run(adult, null));
    }




    @Test
    public void testRun_EqualsStrings() {
        BiPredicate<String, String> equals = String::equals;
        assertTrue(LambdaRunner.run(equals, "cat", "cat"));
        assertFalse(LambdaRunner.run(equals, "cat", "dog"));
    }

    @Test
    public void testRun_SumIsEven() {
        BiPredicate<Integer, Integer> sumIsEven = (a, b) -> (a + b) % 2 == 0;
        assertTrue(LambdaRunner.run(sumIsEven, 2, 4));
        assertFalse(LambdaRunner.run(sumIsEven, 1, 2));
    }

}
