package com.example.springbootjwtexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class UserDTO {

    private Integer id;

    private String fullName;

    private String address;

    private String phoneNumber;

    public UserDTO() {
        super();
    }

    public UserDTO(String fullName, String address, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
