package com.github.tddiaz.domain;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Entity
@Data
public class Person {
    @Id
    private String id;
    private String name;
    private Integer age;
    @Embedded
    private Address address;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
    }
}
