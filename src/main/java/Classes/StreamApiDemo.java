package Classes;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.Comparator;


public class StreamApiDemo extends LambdaDemo {

    public static final UnaryOperator<List<Object>> removeNulls =
            list -> list.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()); // 1
    public static final ToIntFunction<Set<Integer>> countPositive =
            set -> (int) set.stream()
                    .filter(i -> i != null && i > 0)
                    .count(); // 2
    public static final UnaryOperator<List<Object>> lastThree =
            list -> list.stream()
                    .skip(Math.max(0, list.size() - 3))
                    .collect(Collectors.toList()); // 3
    public static final Function<List<Integer>, Integer> firstEvenOrNull =
            list -> list.stream()
                    .filter(i -> i != null && i % 2 == 0)
                    .findFirst().orElse(null); // 4
    public static final Function<int[], List<Integer>> uniqueSquares =
            arr -> Arrays.stream(arr)
                    .map(x -> x * x)
                    .distinct() //Удаляем дубликаты
                    .boxed()//int в stream<integer>
                    .collect(Collectors.toList()); // 5
    public static final Function<List<String>, List<String>> nonEmptySorted =
            list -> list.stream()
                    .filter(s -> s != null && !s.isEmpty())
                    .sorted()
                    .collect(Collectors.toList()); // 6
    public static final Function<Set<String>, List<String>> setToDescendingList =
            set -> set.stream()
                    .sorted(Comparator.nullsLast(Comparator.reverseOrder()))
                    .collect(Collectors.toList()); // 7
    public static final ToIntFunction<Set<Integer>> sumOfSquares =
            set -> set.stream()
                    .filter(Objects::nonNull)
                    .mapToInt(x -> x * x)
                    .sum(); // 8
    public static final ToIntFunction<Collection<PersonInfo>> maxAge =
            col -> col.stream()
                    .filter(Objects::nonNull)
                    .mapToInt(PersonInfo::getAge)
                    .max().orElse(0); // 9
    public static final Function<Collection<PersonInfo>, List<PersonInfo>> sortByGenderThenAge =
            col -> col.stream()
                    .filter(Objects::nonNull)
                    .sorted(Comparator
                            .comparing((PersonInfo p) -> p.getGender() == null ? 0 : p.getGender().ordinal())
                            .thenComparingInt(PersonInfo::getAge))
                    .collect(Collectors.toList()); // 10
}
