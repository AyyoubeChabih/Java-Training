package org.mql.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Form {
	String title() default ""; // c'est obligatoire
	//String action() default "";    c'est pour le web
	//String method() default "GET";
}
