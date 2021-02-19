package com.akash.smartcontacts.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;
    private String secondName;
    private String name;
    private String work;
    private String phone;
    private String imageURL;
    @Column(length=1000)
    private String description;

    @ManyToOne
    private User user;
}
