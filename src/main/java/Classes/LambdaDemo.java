package Classes;

import Enums.Gender;
import Interfaces.TriPredicate;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class LambdaDemo {
    public static final Function<String, Integer> stringLength = String::length; //1
    public static final Function<String, Character> firstChar = s -> (s != null && !s.isEmpty()) ? s.charAt(0) : null;//2
    public static final Predicate<String> noSpace = s -> s != null && !s.contains(" "); //3
    public static final Function<String, Integer> wordCount = s -> s == null || s.isEmpty() ? 0 : s.split("\\s*,\\s*").length;
    public static final Function<Human, Integer> getAge = Human::getAge; //5
    public static final BiPredicate<Human, Human> sameSurname = (h1, h2) -> h1 != null && h2 != null && Objects.equals(h1.getSurname(), h2.getSurname()); //6
    public static final Function<Human, String> getFIO = h -> {
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
    public static final TriPredicate<Human, Human, Human, Integer> humanYoungerThan =
            (h1, h2, h3, maxAge) -> h1 != null && h2 != null && h3 != null && h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge;

    public interface PersonInfo { // интерфейс для 5-7 пунктов
        String getSurname();

        String getFirstname();

        String getPatronymic();

        int getAge();

        Gender getGender();
    }

    public static final ToIntFunction<PersonInfo> personAge = PersonInfo::getAge; //5.1
    public static final BiPredicate<PersonInfo, PersonInfo> sameSurnamePerson =
            (p1, p2) -> p1 != null && p2 != null && Objects.equals(p1.getSurname(), p2.getSurname()); // 6.1
    public static final Function<PersonInfo, String> personFIO = p -> {
        if (p == null) return "";
        return String.join(" ", Arrays.asList(p.getSurname(), p.getFirstname(), p.getPatronymic())); // 7.1
    };

}
