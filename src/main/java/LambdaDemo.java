import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class LambdaDemo {
    public static final Function<String, Integer> stringLength = (String s) -> s.length(); //1
    public static final Function<String, Character> firstChar = (String s) -> (s != null && !s.isEmpty()) ? s.charAt(0) : null;//2
    public static final Predicate<String> noSpace = (String s) -> s != null && !s.contains(" "); //3
    public static final Function<String, Integer> wordCount = (String s) -> { //4
        if (s == null || s.isEmpty()) {
            return 0; // Если строка null или пустая, возвращаем 0
        }
        return s.split("\\s*,\\s*").length;
    };
    public static final Function<Human, Integer> getAge = (Human human) -> human.getAge(); //5
    public static final BiPredicate<Human, Human> sameSurname = (Human h1, Human h2) -> h1 != null && h2 != null && Objects.equals(h1.getSurname(), h2.getSurname()); //6
    public static final Function<Human, String> getFIO = (Human h) -> {
        if (h == null) {
            return "";
        }
        return String.join(" ", Arrays.asList(h.getSurname(), h.getFirstname(), h.getPatronymic()));
    }; //7
    public static final Function<Human, Human> makeOlder = (Human h) -> {
        if ( h == null) {
            return null;
        }
        return new Human(h.getSurname(), h.getFirstname(), h.getPatronymic(), h.getAge() + 1, h.getGender());
    }; //8
    public static final TriPredicate<Human, Human, Human, Integer> humanYoungerThan = (h1, h2, h3, maxAge) -> {
        if (h1 == null || h2 == null || h3 == null) return false;
        return h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge;
    }; //9

    @FunctionalInterface // интерфейс для 9
    interface TriPredicate<T, U, V, W> {
        boolean test(T t, U u, V v, W w);
    }

    public interface PersonInfo { // интерфейс для 5-7 пунктов
        String getSurname();
        String getFirstname();
        String getPatronymic();
        int getAge();
        String getGender();
    }

    public static final ToIntFunction<PersonInfo> personAge = PersonInfo::getAge; //5.1
    public static final BiPredicate<PersonInfo, PersonInfo> sameSurnamePerson =
            (p1, p2) -> p1 != null && p2 != null && Objects.equals(p1.getSurname(), p2.getSurname()); // 6.1
    public static final Function<PersonInfo, String> personFIO = p -> {
        if (p == null) return "";
        return String.join(" ", Arrays.asList(p.getSurname(), p.getFirstname(), p.getPatronymic())); // 7.1
    };

}
