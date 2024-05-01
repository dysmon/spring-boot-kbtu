package kz.kbtu.autowire.service;

import kz.kbtu.autowire.annotations.FormatterType;
import kz.kbtu.autowire.model.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooService {

    @Autowired
    @FormatterType("Foo")
    private Formatter formatter;

    @Autowired
    public FooService(@FormatterType("Foo") Formatter formatter) {
        this.formatter = formatter;
    }

    @Autowired
    public void setFormatter(@FormatterType("Foo") Formatter formatter) {
        this.formatter = formatter;
    }

    public String doStuff() {
        return formatter.format();
    }

}
