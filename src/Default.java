package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания класса по умолчанию или значения по умолчанию.
 *
 * <p>Эта аннотация позволяет указать класс по умолчанию, который должен быть использован
 *  по умолчанию для полей или типов.</p>
 *
 * @since 2024
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {

    /**
     * Класс по умолчанию, который должен быть использован.
     * <p>Определяет класс, который будет служить реализацией по умолчанию </p>
     *
     * @return класс по умолчанию
     */
    Class<?> value();
}
