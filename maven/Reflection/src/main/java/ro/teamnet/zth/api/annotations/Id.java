package ro.teamnet.zth.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by user on 7/7/2016.
 */
@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface Id {

    String name() default "id";
}
