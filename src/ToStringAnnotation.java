import java.lang.reflect.Field;

public class ToStringAnnotation {

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