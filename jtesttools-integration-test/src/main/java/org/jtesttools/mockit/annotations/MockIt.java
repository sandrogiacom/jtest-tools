package org.jtesttools.mockit.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * MockIt is an annotation like @Spy of Mockito project
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface MockIt {
	Class impl();
}
