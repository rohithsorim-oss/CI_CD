package com.rohith.cicdDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(columnNames = {"mail"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String name;

    String mail;

    String password;

    String favoriteFood;


}
