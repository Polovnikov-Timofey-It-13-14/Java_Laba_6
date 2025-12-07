package handlers;

import annotations.Two;

/**
 * Обработчик аннотации {@link annotations.Two}.
 * <p>Предоставляет методы для работы с классами, помеченными аннотацией {@code @Two},
 * включая чтение значений и валидацию.</p>
 *
 * @see annotations.Two
 */
public class TwoAnnotation {

    /**
     * Читает и выводит значения аннотации {@link annotations.Two}.
     * <p>Если класс помечен аннотацией {@code @Two}, выводит значения
     * её свойств {@code first} и {@code second} в консоль.</p>
     *
     * @param classes класс для проверки на наличие аннотации {@code @Two}
     * @throws NullPointerException если переданный класс равен {@code null}
     *
     * @see annotations.Two#first()
     * @see annotations.Two#second()
     */
    public static void processAnnotation(Class<?> classes) {
        if (classes.isAnnotationPresent(Two.class)) {
            Two annotation = classes.getAnnotation(Two.class);
            System.out.println("Аннотация @Two:");
            System.out.println("first: " + annotation.first());
            System.out.println("second: " + annotation.second());
        }
    }

    /**
     * Валидирует аннотацию {@link annotations.Two} и выбрасывает исключение при некорректных значениях.
     *
     * @param classes класс для валидации аннотации {@code @Two}
     * @throws IllegalArgumentException если:
     *
     * @see annotations.Two#first()
     * @see annotations.Two#second()
     */
    public static void validateTwoAnnotation(Class<?> classes) {
        if (!classes.isAnnotationPresent(Two.class)) {
            throw new IllegalArgumentException("Класс " + classes.getSimpleName() + " не содержит аннотацию @Two");
        }

        Two annotation = classes.getAnnotation(Two.class);
        String first = annotation.first();
        int second = annotation.second();

        // Проверка строкового свойства
        if (first == null || first.trim().isEmpty()) {
            throw new IllegalArgumentException("Свойство 'first' не может быть null или пустой строкой. Получено: '" + first + "'");
        }

        // Проверка числового свойства
        if (second < 0) {
            throw new IllegalArgumentException("Свойство 'second' не может быть отрицательным. Получено: " + second);
        }
    }
}
