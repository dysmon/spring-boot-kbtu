package com.kbtu.database.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    // private Employee() {}

}
