import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class InvokeAnnotation {
    //Поиск методов с аннотацией Invoke
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

                    // Делаем метод доступным (даже если он private)
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