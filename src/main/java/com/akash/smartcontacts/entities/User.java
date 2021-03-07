package com.akash.smartcontacts.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Name should not be blank")
    @Size( max = 30, message = "Size should be more than 30")
    private String name;
    @Column(unique = true)
    @NotBlank(message = "email should not be blank")
    private String email;
    @NotBlank(message = "password should not be blank")
    private String password;
    private String role;
    private boolean isEnabled;
    private String imageURL;
    @Column(length=500)
    private String about;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Contact> contacts = new ArrayList<>();

}
