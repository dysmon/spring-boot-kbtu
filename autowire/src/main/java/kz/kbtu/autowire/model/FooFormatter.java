package kz.kbtu.autowire.model;

import org.springframework.stereotype.Component;
import kz.kbtu.autowire.annotations.FormatterType;

@FormatterType("Foo")
@Component
public class FooFormatter implements Formatter {

    public String format() {
        return "foo";
    }

}