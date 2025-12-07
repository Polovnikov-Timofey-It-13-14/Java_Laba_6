package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация с двумя обязательными свойствами.
 *
 * <p>Эта аннотация предназначена для пометки классов и содержит
 * два обязательных параметра: строковый и числовой.</p>
 *
 * @see java.lang.annotation.Annotation
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {

    /**
     * Строковое свойство аннотации.
     * <p>Это обязательное свойство, которое должно быть указано
     * при использовании аннотации {@code @Two}.</p>
     *
     * @return строковое значение свойства
     */
    String first();

    /**
     * Числовое свойство аннотации.
     * <p>Это обязательное свойство, которое должно быть указано
     * при использовании аннотации {@code @Two}.</p>
     *
     * @return целочисленное значение свойства
     */
    int second();
}
