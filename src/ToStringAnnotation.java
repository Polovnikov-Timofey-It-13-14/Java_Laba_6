package handlers;

import annotations.ToString;

import java.lang.reflect.Field;

/**
 * Обработчик аннотации {@link annotations.ToString}.
 * <p>Предоставляет функциональность для генерации строкового представления
 * объектов с учетом аннотации {@code @ToString}.</p>
 *
 * @see annotations.ToString.Mode
 */
public class ToStringAnnotation {

    /**
     * Генерирует строковое представление объекта с учетом аннотации {@link annotations.ToString}.
     *
     * @param object объект для генерации строкового представления
     * @return строковое представление объекта или "null", если объект равен {@code null}
     *
     * @see #shouldInclude(Field, Class)
     */
    public static String toString(Object object) {
        if (object == null) return "null";

        Class<?> classes = object.getClass();
        StringBuilder result = new StringBuilder();
        result.append(classes.getSimpleName()).append("{");

        Field[] fields = classes.getDeclaredFields();
        boolean firstField = true;

        for (Field field : fields) {
            if (shouldInclude(field, classes)) {
                try {
                    field.setAccessible(true);
                    if (!firstField) result.append(", ");
                    result.append(field.getName()).append("='").append(field.get(object)).append("'");
                    firstField = false;
                } catch (Exception e) {
                    result.append(field.getName()).append("=ERROR");
                }
            }
        }

        return result.append("}").toString();
    }

    /**
     * Определяет, должно ли поле быть включено в строковое представление.
     * <p>Проверяет наличие и значения аннотации {@code @ToString}:
     *
     * @param field поле для проверки
     * @param classes класс, к которому принадлежит поле
     * @return {@code true} если поле должно быть включено в строковое представление,
     *         {@code false} если поле должно быть исключено
     */
    private static boolean shouldInclude(Field field, Class<?> classes) {
        ToString fieldAnnotation = field.getAnnotation(ToString.class);
        if (fieldAnnotation != null) {
            return fieldAnnotation.value() == ToString.Mode.YES;
        }

        ToString classAnnotation = classes.getAnnotation(ToString.class);
        if (classAnnotation != null) {
            return classAnnotation.value() == ToString.Mode.YES;
        }

        return true;
    }
}
