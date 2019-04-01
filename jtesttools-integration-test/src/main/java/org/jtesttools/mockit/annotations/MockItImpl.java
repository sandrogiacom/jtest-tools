package org.jtesttools.mockit.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * MockItImpl is an annotation that mark class as a MockClient implementation of @{@link MockIt}
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface MockItImpl {
}
