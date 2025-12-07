package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания кэшируемых свойств или методов.
 *
 * <p>Эта аннотация используется для пометки классов, указывая, какие свойства
 * или методы должны быть кэшированы.</p>
 *
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {

    /**
     * Массив имен свойств или методов, которые должны быть кэшированы.
     * <p>Определяет, какие именно элементы класса подлежат кэшированию. </p>
     *
     * @return массив имен свойств или методов для кэширования
     */
    String[] value() default {};
}
