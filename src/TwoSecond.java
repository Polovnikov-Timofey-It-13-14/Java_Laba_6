package service;

import annotations.Two;

/**
 * Класс с некорректной аннотацией {@link annotations.Two}.
 * <p>Используется для тестирования обработки ошибок валидации аннотации {@code @Two}.
 * Содержит аннотацию с отрицательным значением в свойстве {@code second}, что является
 * некорректным значением.</p>
 *
 * <p>Аннотация содержит:
 * <ul>
 *   <li>{@code first = "ValidString"} - валидная непустая строка</li>
 *   <li>{@code second = -1} - отрицательное число (некорректное значение)</li>
 * </ul>
 * </p>
 *
 * @see annotations.Two
 * @see handlers.TwoAnnotation#validateTwoAnnotation(Class)
 */
@Two(first = "ValidString", second = -1)  // first - валидный, second - отрицательный
public class TwoSecond {

    /**
     * Создает экземпляр класса {@code TwoSecond}.
     */
    public TwoSecond() {
        // Пустой конструктор
    }

    /**
     * Возвращает строковое представление объекта.
     *
     * @return строку "InvalidSecondClass{}"
     */
    @Override
    public String toString() {
        return "InvalidSecondClass{}";
    }
}
