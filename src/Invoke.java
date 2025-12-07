package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для пометки методов, которые должны быть автоматически вызваны.
 *
 * <p>Эта аннотация используется для указания методов, которые требуется
 * выполнить автоматически.</p>
 *
 * @see java.lang.reflect.Method
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
}
