package Interfaces;

@FunctionalInterface
public// интерфейс для 9
interface TriPredicate<T, U, V, W> {
    boolean test(T t, U u, V v, W w);
}