package Classes;

import java.util.function.*;

public class LambdaRunner {

    public static <T, R> R run(Function<T, R> lambda, T param) {
        return lambda.apply(param);
    }

    public static <T, U, R> R run(BiFunction<T, U, R> lambda, T param1, U param2) {
        return lambda.apply(param1, param2);
    }

    public static <R> R run(Supplier<R> lambda) {
        return lambda.get();
    }

    public static <T> void run(Consumer<T> lambda, T param) {
        lambda.accept(param);
    }

    public static <T, U> void run(BiConsumer<T, U> lambda, T param1, U param2) {
        lambda.accept(param1, param2);
    }

    public static <T> boolean run(Predicate<T> lambda, T param) {
        return lambda.test(param);
    }

    public static <T, U> boolean run(BiPredicate<T, U> lambda, T param1, U param2) {
        return lambda.test(param1, param2);
    }
}
