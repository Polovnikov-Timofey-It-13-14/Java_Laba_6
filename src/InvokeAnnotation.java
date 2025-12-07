package handlers;

import annotations.Invoke;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * Обработчик аннотации {@link annotations.Invoke}.
 * <p>Предоставляет функциональность для поиска и автоматического вызова методов,
 * помеченных аннотацией {@code @Invoke}.</p>
 *
 * @see annotations.Invoke
 */
public class InvokeAnnotation {

    /**
     * Находит и вызывает все методы с аннотацией {@link annotations.Invoke}
     * в переданном объекте.
     *
     * @param target объект, методы которого нужно проанализировать и вызвать
     * @throws IllegalArgumentException если {@code target} равен {@code null}
     * @throws SecurityException если нет доступа к методам класса
     *
     * @see #WithParameters(Method, Object)
     * @see #getDefaultValue(Class)
     */
    public static void invokeAnnotatedMethods(Object target) {
        if (target == null) {
            throw new IllegalArgumentException("Целевой объект не может быть null");
        }

        Class<?> classes = target.getClass();

        Method[] methods = classes.getDeclaredMethods();

        int invokedCount = 0;

        System.out.println("Всего методов в классе: " + methods.length);

        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    System.out.println("Найден метод с @Invoke: " + method.getName() +
                            " (параметры: " + method.getParameterCount() + ")");

                    // Делаем метод доступным
                    method.setAccessible(true);

                    Object result = WithParameters(method, target);

                    if (result != null) {
                        System.out.println("Результат метода: " + result);
                    }

                    invokedCount++;
                    System.out.println("Метод успешно вызван");

                } catch (Exception e) {
                    System.err.println("Ошибка при вызове метода " + method.getName() +
                            ": " + e.getMessage());
                }
            }
        }

        System.out.println("Вызвано методов: " + invokedCount);
    }

    /**
     * Вызывает метод с заполнением параметров значениями по умолчанию.
     * <p>Если метод имеет параметры, создается массив значений по умолчанию
     * в соответствии с типами параметров.</p>
     *
     * @param method метод для вызова
     * @param target объект, метод которого нужно вызвать
     * @return результат выполнения метода или {@code null}, если метод возвращает {@code void}
     * @throws IllegalAccessException если нет доступа к методу
     * @throws InvocationTargetException если при вызове метода произошло исключение
     *
     * @see #getDefaultValue(Class)
     */
    private static Object WithParameters(Method method, Object target)
            throws IllegalAccessException, InvocationTargetException {

        Class<?>[] parameterTypes = method.getParameterTypes();

        Object[] parameters = new Object[parameterTypes.length];

        // Заполняем параметры значениями по умолчанию
        for (int i = 0; i < parameterTypes.length; i++) {
            parameters[i] = getDefaultValue(parameterTypes[i]);
        }
        return method.invoke(target, parameters);
    }

    /**
     * Возвращает значение по умолчанию для указанного типа.
     *
     * @param type тип, для которого нужно получить значение по умолчанию
     * @return значение по умолчанию для указанного типа
     */
    private static Object getDefaultValue(Class<?> type) {
        if (type == int.class || type == Integer.class) {
            return 0;
        } else if (type == long.class || type == Long.class) {
            return 0L;
        } else if (type == double.class || type == Double.class) {
            return 0.0;
        } else if (type == float.class || type == Float.class) {
            return 0.0f;
        } else if (type == boolean.class || type == Boolean.class) {
            return false;
        } else if (type == char.class || type == Character.class) {
            return '\0';
        } else if (type == String.class) {
            return null; // Значение по умолчанию для настроения
        } else {
            return null; // Для объектов
        }
    }
}
