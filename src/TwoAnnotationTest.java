import handlers.TwoAnnotation;
import model.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import service.TwoFirst;
import service.TwoSecond;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки обработки аннотации {@link annotations.Two} и валидации.
 *
 * @see annotations.Two
 * @see handlers.TwoAnnotation
 */
//Тестовый класс для проверки обработки некорректной аннотации @Two
public class TwoAnnotationTest {

    /**
     * Тест проверяет выброс исключения при пустой строке в свойстве {@code first}.
     */
    @Test
    @DisplayName("Проверка обработки пустой строки в свойстве first")
    void testEmptyFirstProperty() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TwoAnnotation.validateTwoAnnotation(TwoFirst.class),
                "Должно выбрасываться IllegalArgumentException для пустого свойства first"
        );

        assertTrue(exception.getMessage().contains("Свойство 'first' не может быть null или пустой строкой"),
                "Сообщение исключения должно указывать на проблему с first: " + exception.getMessage());
    }

    /**
     * Тест проверяет выброс исключения при отрицательном значении в свойстве {@code second}.
     */
    @Test
    @DisplayName("Проверка обработки отрицательного значения в свойстве second")
    void testNegativeSecondProperty() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TwoAnnotation.validateTwoAnnotation(TwoSecond.class),
                "Должно выбрасываться IllegalArgumentException для отрицательного свойства second"
        );

        assertTrue(exception.getMessage().contains("Свойство 'second' не может быть отрицательным"),
                "Сообщение исключения должно указывать на проблему с second: " + exception.getMessage());
    }

    /**
     * Тест проверяет корректную обработку валидной аннотации.
     */
    @Test
    @DisplayName("Проверка корректной обработки валидной аннотации")
    void testValidAnnotation() {
        assertDoesNotThrow(
                () -> TwoAnnotation.validateTwoAnnotation(Car.class),
                "Валидация должна проходить успешно для корректной аннотации @Two"
        );
    }

    /**
     * Тест проверяет обработку класса без аннотации {@link annotations.Two}.
     */
    @Test
    @DisplayName("Проверка обработки класса без аннотации @Two")
    void testClassWithoutAnnotation() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TwoAnnotation.validateTwoAnnotation(String.class),
                "Должно выбрасываться IllegalArgumentException для класса без аннотации @Two"
        );

        assertTrue(exception.getMessage().contains("не содержит аннотацию @Two"),
                "Сообщение исключения должно указывать на отсутствие аннотации: " + exception.getMessage());
    }
}
