package handlers;

import annotations.Cache;

/**
 * Обработчик аннотации {@link annotations.Cache}.
 * <p>Предоставляет функциональность для анализа и обработки классов,
 * помеченных аннотацией {@code @Cache}.</p>
 *
 */
public class CacheAnnotation {

    /**
     * Обрабатывает аннотацию {@link annotations.Cache} и выводит результат.
     * <p>Метод анализирует переданный класс на наличие аннотации {@code @Cache}
     * и выводит информацию о кэшируемых областях, если аннотация присутствует.</p>
     *
     * @see annotations.Cache
     */
    public static void processCacheAnnotation(Class<?> classes) {
        if (classes.isAnnotationPresent(Cache.class)) {
            Cache annotation = classes.getAnnotation(Cache.class);
            String[] areas = annotation.value();

            if (areas.length > 0) {
                System.out.println("Найдены кешируемые области: " + String.join(", ", areas));
            } else {
                System.out.println("Список кешируемых областей пуст");
            }
        } else {
            System.out.println("Аннотация @Cache не найдена в классе: " + classes.getSimpleName());
        }
    }
}
