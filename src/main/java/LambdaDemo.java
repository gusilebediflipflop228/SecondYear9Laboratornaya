import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

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


}
