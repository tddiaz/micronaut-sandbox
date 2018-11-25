package com.github.tddiaz;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController {

    @Get(value = "/{name}", produces = MediaType.APPLICATION_JSON)
    String hello(String name) {
        return "Hello " + name;
    }
}
