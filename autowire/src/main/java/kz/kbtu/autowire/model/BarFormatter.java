package kz.kbtu.autowire.model;

import kz.kbtu.autowire.annotations.FormatterType;
import org.springframework.stereotype.Component;

@FormatterType("Bar")
@Component
public class BarFormatter implements Formatter {

    public String format() {
        return "bar";
    }

}
