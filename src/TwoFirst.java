package service;

import annotations.Two;

/**
 * Класс с некорректной аннотацией {@link annotations.Two}.
 * <p>Используется для тестирования обработки ошибок валидации аннотации {@code @Two}.
 * Содержит аннотацию с пустой строкой в свойстве {@code first}, что является
 * некорректным значением.</p>
 *
 * <p>Аннотация содержит:
 * <ul>
 *   <li>{@code first = ""} - пустая строка (некорректное значение)</li>
 *   <li>{@code second = 123} - валидное положительное число</li>
 * </ul>
 * </p>
 *
 * @see annotations.Two
 * @see handlers.TwoAnnotation#validateTwoAnnotation(Class)
 */
@Two(first = "", second = 123)  // first - пустая строка, second - валидный
public class TwoFirst {

    /**
     * Создает экземпляр класса {@code TwoFirst}.
     */
    public TwoFirst() {
        // Пустой конструктор
    }

    /**
     * Возвращает строковое представление объекта.
     *
     * @return строку "InvalidFirstClass{}"
     */
    @Override
    public String toString() {
        return "InvalidFirstClass{}";
    }
}
