package com.olmez.lil.learning_spring.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "GUEST")
@Data
public class Guest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "GUEST_ID")
  private long guestId;

  @Column(name = "FIRST_NAME") private String firstName;

  @Column(name = "LAST_NAME") private String lastName;

  @Column(name = "EMAIL_ADDRESS") private String emailAddress;

  @Column(name = "ADDRESS") private String address;

  @Column(name = "COUNTRY") private String country;

  @Column(name = "STATE") private String state;

  @Column(name = "PHONE_NUMBER") private String phoneNumber;
}
