public class TwoAnnotation {

    //Читает и выводит значения аннотации @Two
    public static void processAnnotation(Class<?> classes) {
        if (classes.isAnnotationPresent(Two.class)) {
            Two annotation = classes.getAnnotation(Two.class);
            System.out.println("Аннотация @Two:");
            System.out.println("first: " + annotation.first());
            System.out.println("second: " + annotation.second());
        }
    }

    //Валидирует аннотацию @Two и выбрасывает исключение при некорректных значениях
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
