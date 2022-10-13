package com.example.springsecuritymaster.ds;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Code cannot be empty")
    @Pattern(regexp = "[A-Za-z]*", message = "Code cannot contain Illegal characters")
    private String code;

    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "[A-Za-z]*", message = "Name cannot contain Illegal characters")
    private String country;

    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "[A-Za-z]*", message = "Name cannot contain Illegal characters")
    private String name;

}
