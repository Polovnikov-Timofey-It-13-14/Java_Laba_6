package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для управления включением полей или классов в строковое представление.
 *
 * <p>Эта аннотация позволяет контролировать, должно ли поле или класс
 * включаться в результат метода {@code toString()}. Может применяться
 * как к классам, так и к отдельным полям.</p>
 *
 * @see java.lang.Object#toString()
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {

    /**
     * Определяет режим включения элемента в строковое представление.
     * <p>Позволяет указать, должен ли аннотированный элемент
     * (класс или поле) быть включен в результат метода {@code toString()}.</p>
     *
     * @return режим включения в строковое представление
     */
    Mode value() default Mode.YES;

    /**
     * Перечисление режимов для аннотации {@link ToString}.
     */
    enum Mode {

        /**
         * Элемент должен быть включен в строковое представление.
         * <p>Это значение по умолчанию для аннотации {@link ToString}.</p>
         */
        YES,
        /**
         * Элемент должен быть исключен из строкового представления.
         * <p>Используется для скрытия конфиденциальной или несущественной информации
         * в строковом представлении объекта.</p>
         */
        NO
    }
}
