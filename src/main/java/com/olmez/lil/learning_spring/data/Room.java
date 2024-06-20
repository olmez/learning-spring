package com.olmez.lil.learning_spring.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ROOM")
@Data
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ROOM_ID")
  private long id;

  @Column(name = "NAME") private String name;

  @Column(name = "ROOM_NUMBER") private String roomNumber;

  @Column(name = "BED_INFO") private String badInfo;

}
