package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания классов валидаторов, которые должны быть применены.
 *
 * <p>Эта аннотация используется для пометки классов или других аннотаций.</p>
 *
 * @see java.lang.annotation.Annotation
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {

    /**
     * Массив классов валидаторов, которые должны быть применены.</p>
     *
     * @return массив классов валидаторов
     */
    Class<?>[] value();
}
