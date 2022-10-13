package com.example.springsecuritymaster.ds;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 2,max = 5,message = "Code must be between 2 and 5")
    @Pattern(regexp = "[A-Za-z]*",message = "Code contains illegal characters")
    private String code;

    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "[A-Za-z-]*",message = "First name should not contain illegal characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "[A-Za-z-]*",message = "Last name should not contain illegal characters")
    private String lastName;

    @NotBlank(message = "Address cannot be empty")
    @Pattern(regexp = "[\\w .\\-/,]*",message = "Address should not contain illegal characters")
    private String address;

    public Customer() {
    }

    public Customer(String code, String firstName, String lastName, String address) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
