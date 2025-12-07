package handlers;

import annotations.Validate;

/**
 * Обработчик аннотации {@link annotations.Validate}.
 * <p>Предоставляет методы для анализа классов, помеченных аннотацией {@code @Validate},
 * и вывода информации о классах валидаторов.</p>
 *
 * @see annotations.Validate
 */
public class ValidateAnnotation {

    /**
     * Обрабатывает аннотацию {@link annotations.Validate} и выводит информацию о классах валидаторов.
     *
     * @param classes класс для проверки на наличие аннотации {@code @Validate}
     * @throws NullPointerException если переданный класс равен {@code null}
     *
     * @see annotations.Validate#value()
     */
    public static void processClass(Class<?> classes) {
        if (classes.isAnnotationPresent(Validate.class)) {
            Validate annotation = classes.getAnnotation(Validate.class);
            Class<?>[] validationClasses = annotation.value();

            System.out.println("Найдена аннотация @Validate");
            System.out.println("Классы для проверки: " + validationClasses.length);

            for (int i = 0; i < validationClasses.length; i++) {
                System.out.println("   " + (i + 1) + ". " +
                        validationClasses[i].getName() +
                        " (" + validationClasses[i].getSimpleName() + ")");
            }

        } else {
            System.out.println("Аннотация @Validate не найдена");
        }
    }
}
