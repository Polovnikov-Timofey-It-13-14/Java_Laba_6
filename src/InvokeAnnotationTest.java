import annotations.Invoke;
import handlers.InvokeAnnotation;
import model.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Тестовый класс для проверки аннотации {@link annotations.Invoke} и класса {@link handlers.InvokeAnnotation}.
 *
 * @see annotations.Invoke
 * @see handlers.InvokeAnnotation
 * @see model.Human
 */
//Тестовый класс для проверки аннотации @Invoke
class InvokeAnnotationTest {

    /** Тестируемый объект класса {@link model.Human}. */
    private Human human;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Подготовка тестового объекта перед каждым тестом.
     * <p>Выполняет:
     * <ul>
     *   <li>Создание объекта {@link model.Human} с именем "Иван" и возрастом 25</li>
     *   <li>Перенаправление стандартного вывода в {@code ByteArrayOutputStream}</li>
     * </ul>
     * </p>
     */
    @BeforeEach
    void setUp() {
        human = new Human("Иван", 25);
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Тест проверяет наличие аннотации {@link annotations.Invoke} на методах класса {@link model.Human}.
     * <p>Проверяет, что:
     * <ul>
     *   <li>Существует хотя бы один метод с аннотацией {@code @Invoke}</li>
     *   <li>Точное количество аннотированных методов равно 4</li>
     * </ul>
     * </p>
     *
     * <p>Ожидаемые методы с аннотацией {@code @Invoke}:
     * <ol>
     *   <li>{@link model.Human#sayHello()}</li>
     *   <li>{@link model.Human#introduce(String)}</li>
     *   <li>{@link model.Human#checkAdult()}</li>
     *   <li>{@link model.Human#celebrateBirthday()}</li>
     * </ol>
     * </p>
     */
    @Test
    @DisplayName("Проверка наличия аннотации @Invoke на методах")
    void testInvokeAnnotationPresence() {
        Method[] methods = human.getClass().getDeclaredMethods();
        int annotatedMethodsCount = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                annotatedMethodsCount++;
                System.out.println("Найден метод с @Invoke: " + method.getName());
            }
        }

        assertTrue(annotatedMethodsCount > 0, "Должен быть хотя бы один метод с аннотацией @Invoke");
        assertEquals(4, annotatedMethodsCount, "Должно быть 4 метода с аннотацией @Invoke");
    }

    /**
     * Тест проверяет вызов метода {@link model.Human#sayHello()} с аннотацией {@link annotations.Invoke}.
     */
    @Test
    @DisplayName("Проверка вызова метода sayHello")
    void testSayHelloMethod() {
        try {
            Method sayHelloMethod = human.getClass().getDeclaredMethod("sayHello");
            assertTrue(sayHelloMethod.isAnnotationPresent(Invoke.class));

            // Вызываем метод через рефлексию
            sayHelloMethod.invoke(human);

            String output = outputStream.toString();
            assertTrue(output.contains("Иван говорит: Привет! Мне 25 лет."));

        } catch (Exception e) {
            fail("Метод sayHello должен выполняться без исключений: " + e.getMessage());
        }
    }

    /**
     * Тест проверяет вызов метода {@link model.Human#introduce(String)} с аннотацией {@link annotations.Invoke}.
     */
    @Test
    @DisplayName("Проверка вызова метода introduce")
    void testIntroduceMethod() {
        try {
            Method introduceMethod = human.getClass().getDeclaredMethod("introduce", String.class);
            assertTrue(introduceMethod.isAnnotationPresent(Invoke.class));

            // Вызываем метод с параметром
            Object result = introduceMethod.invoke(human, "отличное");

            String output = outputStream.toString();
            assertTrue(output.contains("Меня зовут Иван, мне 25 лет. Настроение: отличное"));

            // Проверяем возвращаемое значение
            assertNotNull(result);
            assertInstanceOf(String.class, result);
            String resultString = (String) result;
            assertTrue(resultString.contains("Иван"));
            assertTrue(resultString.contains("25"));
            assertTrue(resultString.contains("отличное"));

        } catch (Exception e) {
            fail("Метод introduce должен выполняться без исключений: " + e.getMessage());
        }
    }

    /**
     * Тест проверяет вызов метода {@link model.Human#checkAdult()} с аннотацией {@link annotations.Invoke}.
     */
    @Test
    @DisplayName("Проверка вызова метода checkAdult")
    void testCheckAdultMethod() {
        try {
            Method checkAdultMethod = human.getClass().getDeclaredMethod("checkAdult");
            assertTrue(checkAdultMethod.isAnnotationPresent(Invoke.class));

            // Вызываем метод
            checkAdultMethod.invoke(human);

            String output = outputStream.toString();
            assertTrue(output.contains("Иван совершеннолетний(яя)"));

        } catch (Exception e) {
            fail("Метод checkAdult должен выполняться без исключений: " + e.getMessage());
        }
    }

    /**
     * Тест проверяет вызов метода {@link model.Human#celebrateBirthday()} с аннотацией {@link annotations.Invoke}.
     */
    @Test
    @DisplayName("Проверка вызова метода celebrateBirthday и изменения состояния")
    void testCelebrateBirthdayMethod() {
        try {
            Method celebrateBirthdayMethod = human.getClass().getDeclaredMethod("celebrateBirthday");
            assertTrue(celebrateBirthdayMethod.isAnnotationPresent(Invoke.class));

            // Сохраняем начальный возраст
            int initialAge = human.getAge();

            // Вызываем метод
            celebrateBirthdayMethod.invoke(human);

            String output = outputStream.toString();
            assertTrue(output.contains("С днем рождения, Иван! Теперь тебе " + (initialAge + 1) + " лет."));

            // Проверяем изменение состояния объекта
            assertEquals(initialAge + 1, human.getAge(), "Возраст должен увеличиться на 1");

        } catch (Exception e) {
            fail("Метод celebrateBirthday должен выполняться без исключений: " + e.getMessage());
        }
    }

    /**
     * Тест проверяет работу класса {@link handlers.InvokeAnnotation}.
     */
    @Test
    @DisplayName("Проверка работы InvokeAnnotation класса")
    void testInvokeAnnotationClass() {
        try {
            // Очищаем вывод перед тестом
            outputStream.reset();

            // Вызываем все аннотированные методы
            InvokeAnnotation.invokeAnnotatedMethods(human);

            String output = outputStream.toString();

            // Проверяем, что все аннотированные методы были вызваны
            assertTrue(output.contains("Найден метод с @Invoke: sayHello"));
            assertTrue(output.contains("Найден метод с @Invoke: introduce"));
            assertTrue(output.contains("Найден метод с @Invoke: checkAdult"));
            assertTrue(output.contains("Найден метод с @Invoke: celebrateBirthday"));
            assertTrue(output.contains("Вызвано методов: 4"));

        } catch (Exception e) {
            fail("InvokeAnnotation должен работать без исключений: " + e.getMessage());
        }
    }

    /**
     * Тест проверяет поведение с несовершеннолетним человеком.
     */
    @Test
    @DisplayName("Проверка с несовершеннолетним человеком")
    void testUnderageHuman() {
        Human underageHuman = new Human("Анна", 16);

        try {
            Method checkAdultMethod = underageHuman.getClass().getDeclaredMethod("checkAdult");
            checkAdultMethod.invoke(underageHuman);

            String output = outputStream.toString();
            assertTrue(output.contains("Анна несовершеннолетний(яя)"));

        } catch (Exception e) {
            fail("Метод checkAdult должен работать для несовершеннолетних: " + e.getMessage());
        }
    }

    /**
     * Тест проверяет обработку исключений в {@link handlers.InvokeAnnotation}.
     */
    @Test
    @DisplayName("Проверка обработки null объекта")
    void testNullObjectHandling() {
        assertThrows(IllegalArgumentException.class, () -> {
            InvokeAnnotation.invokeAnnotatedMethods(null);
        }, "Должно выбрасываться исключение для null объекта");
    }

    /**
     * <p>Вызывается после каждого теста для восстановления стандартного потока вывода.</p>
     */
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
