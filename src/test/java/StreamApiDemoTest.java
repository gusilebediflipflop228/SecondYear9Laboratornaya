import Classes.HumanPersonInfoAdapter;
import Classes.LambdaDemo;
import Classes.StreamApiDemo;
import Enums.Gender;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StreamApiDemoTest {

    @Test
    public void testRemoveNullsFromListWithNulls() {
        List<Object> input = Arrays.asList("a", null, "b", null, "c");
        List<Object> expected = Arrays.asList("a", "b", "c");
        List<Object> result = StreamApiDemo.removeNulls.apply(input);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveNullsFromListWithoutNulls() {
        List<Object> input = Arrays.asList(1, 2, 3);
        List<Object> expected = Arrays.asList(1, 2, 3);
        List<Object> result = StreamApiDemo.removeNulls.apply(input);
        assertEquals(expected, result);
    }



    @Test
    public void testCountPositiveMixedNumbers() {
        Set<Integer> input = new HashSet<>(Arrays.asList(-3, 0, 2, 5, -1, 8));
        int result = StreamApiDemo.countPositive.applyAsInt(input);
        assertEquals(3, result); // 2, 5, 8
    }

    @Test
    public void testCountPositiveAllPositive() {
        Set<Integer> input = new HashSet<>(Arrays.asList(1, 2, 3));
        int result = StreamApiDemo.countPositive.applyAsInt(input);
        assertEquals(3, result);
    }




    @Test
    public void testLastThree_MoreThanThreeElements() {
        List<Object> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Object> result = StreamApiDemo.lastThree.apply(input);
        assertEquals(Arrays.asList(4, 5, 6), result);
    }

    @Test
    public void testLastThree_ExactlyThreeElements() {
        List<Object> input = Arrays.asList("a", "b", "c");
        List<Object> result = StreamApiDemo.lastThree.apply(input);
        assertEquals(Arrays.asList("a", "b", "c"), result);
    }

    @Test
    public void testLastThree_LessThanThreeElements() {
        List<Object> input = Arrays.asList(7, 8);
        List<Object> result = StreamApiDemo.lastThree.apply(input);
        assertEquals(Arrays.asList(7, 8), result);
    }




    @Test
    public void testFirstEvenOrNull_MixedNumbers() {
        List<Integer> input = Arrays.asList(1, 3, 5, 6, 7, 8);
        Integer result = StreamApiDemo.firstEvenOrNull.apply(input);
        assertEquals(Optional.of(6), Optional.of(result)); // 6 is the first even number
    }

    @Test
    public void testFirstEvenOrNull_NoEvenNumbers() {
        List<Integer> input = Arrays.asList(1, 3, 5, 7);
        Integer result = StreamApiDemo.firstEvenOrNull.apply(input);
        assertNull(result);
    }




    @Test
    public void testUniqueSquares_MixedNumbers() {
        int[] input = {1, -1, 2, -2, 3};
        List<Integer> result = StreamApiDemo.uniqueSquares.apply(input);
        // 1*1=1, (-1)*(-1)=1, 2*2=4, (-2)*(-2)=4, 3*3=9 => [1, 4, 9]
        assertEquals(Arrays.asList(1, 4, 9), result);
    }

    @Test
    public void testUniqueSquares_WithDuplicates() {
        int[] input = {2, 2, -2, 2};
        List<Integer> result = StreamApiDemo.uniqueSquares.apply(input);
        assertEquals(Collections.singletonList(4), result);
    }




    @Test
    public void testNonEmptySorted_MixedStrings() {
        List<String> input = Arrays.asList("banana", "", "apple", "pear", null, "orange");
        List<String> result = StreamApiDemo.nonEmptySorted.apply(input);
        // only non-empty and non-null: "apple", "banana", "orange", "pear"
        assertEquals(Arrays.asList("apple", "banana", "orange", "pear"), result);
    }

    @Test
    public void testNonEmptySorted_AllEmptyOrNull() {
        List<String> input = Arrays.asList("", null, "", null);
        List<String> result = StreamApiDemo.nonEmptySorted.apply(input);
        assertTrue(result.isEmpty());
    }




    @Test
    public void testSetToDescendingList_MixedStrings() {
        Set<String> input = new HashSet<>(Arrays.asList("banana", "apple", "pear", "orange"));
        List<String> result = StreamApiDemo.setToDescendingList.apply(input);
        // Sorted descending: "pear", "orange", "banana", "apple"
        assertEquals(Arrays.asList("pear", "orange", "banana", "apple"), result);
    }

    @Test
    public void testSetToDescendingList_WithNulls() {
        Set<String> input = new HashSet<>(Arrays.asList("abc", null, "def"));
        List<String> result = StreamApiDemo.setToDescendingList.apply(input);
        // nulls should be last: "def", "abc", null
        assertEquals(Arrays.asList("def", "abc", null), result);
    }




    @Test
    public void testSumOfSquares_MixedNumbers() {
        Set<Integer> input = new HashSet<>(Arrays.asList(1, -2, 3));
        int result = StreamApiDemo.sumOfSquares.applyAsInt(input);
        // 1*1 + (-2)*(-2) + 3*3 = 1 + 4 + 9 = 14
        assertEquals(14, result);
    }

    @Test
    public void testSumOfSquares_WithZero() {
        Set<Integer> input = new HashSet<>(Arrays.asList(0, 2, -2));
        int result = StreamApiDemo.sumOfSquares.applyAsInt(input);
        // 0*0 + 2*2 + (-2)*(-2) = 0 + 4 + 4 = 8
        assertEquals(8, result);
    }




    @Test
    public void testMaxAge_MixedAges() {
        Collection<LambdaDemo.PersonInfo> people = Arrays.asList(
                new HumanPersonInfoAdapter("Иванов", "Иван", "Иванович", 30, Gender.MAlE),
                new HumanPersonInfoAdapter("Сидоров", null, "Александрович", 40, Gender.MAlE));
        int result = StreamApiDemo.maxAge.applyAsInt(people);
        assertEquals(40, result);
    }

    @Test
    public void testMaxAge_EmptyCollection() {
        Collection<LambdaDemo.PersonInfo> people = Collections.emptyList();
        int result = StreamApiDemo.maxAge.applyAsInt(people);
        assertEquals(0, result);
    }




    @Test
    public void testSortsByGenderThenAge() {

        List<LambdaDemo.PersonInfo> people = Arrays.asList(
                new HumanPersonInfoAdapter("Иванов", "Иван", "Иванович", 30, Gender.MAlE),
                new HumanPersonInfoAdapter("Сидоров", "null", "Александрович", 40, Gender.MAlE),
                new HumanPersonInfoAdapter("Загребина", "Анастасия", "Викторовна", 40, Gender.FEMALE),
                new HumanPersonInfoAdapter("Овсяннникова", "Елизавета", "Сергеевна", 30, Gender.FEMALE));
        List<LambdaDemo.PersonInfo> result = StreamApiDemo.sortByGenderThenAge.apply(people);

        List<LambdaDemo.PersonInfo> expected = Arrays.asList(
                new HumanPersonInfoAdapter("Иванов", "Иван", "Иванович", 30, Gender.MAlE),
                new HumanPersonInfoAdapter("Сидоров", "null", "Александрович", 40, Gender.MAlE),
                new HumanPersonInfoAdapter("Овсяннникова", "Елизавета", "Сергеевна", 30, Gender.FEMALE),
                new HumanPersonInfoAdapter("Загребина", "Анастасия", "Викторовна", 40, Gender.FEMALE));
        assertEquals(expected, result);
    }




}
