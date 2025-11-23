public class CacheAnnotation {

    //Обрабатывает аннотацию @Cache и выводит результат
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

    //Получает массив кешируемых областей и выводит массив областей или null если аннотация отсутствует
    public static String[] getCacheAreas(Class<?> classes) {
        if (classes.isAnnotationPresent(Cache.class)) {
            Cache annotation = classes.getAnnotation(Cache.class);
            return annotation.value();
        }
        return null;
    }
}