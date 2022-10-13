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
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First Name cannot be blanked")
    @Pattern(regexp = "[A-Za-z]*", message = "First Name cannot contain Illegal Characters")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blanked")
    @Pattern(regexp = "[A-Za-z]*", message = "Last Name cannot contain Illegal Characters")
    private String lastName;

    @NotBlank(message = "Phone Number cannot be blank")
    @Pattern(regexp = "[0-9\\-+]*",message = "Phone number should not contain illegal characters")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be empty")
    @Pattern(regexp = "[\\w .\\-/,]*",message = "Address should not contain illegal characters")
    private String address;

    @NotBlank(message = "CUBICLE No cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9\\-]*")
    private String cubicleNo;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String phoneNumber, String address, String cubicleNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cubicleNo = cubicleNo;
    }
}
