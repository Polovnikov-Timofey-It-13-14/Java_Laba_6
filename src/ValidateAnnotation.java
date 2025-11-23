public class ValidateAnnotation {

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