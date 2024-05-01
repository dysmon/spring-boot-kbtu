package kz.kbtu.autowire.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Qualifier
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface FormatterType {

    String value();

}
