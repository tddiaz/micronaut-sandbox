package com.github.tddiaz.application.controller;

import com.github.tddiaz.domain.Person;
import io.micronaut.http.HttpResponse;

public interface PersonEndpoints {
    HttpResponse<Person> get(String personId);
}
