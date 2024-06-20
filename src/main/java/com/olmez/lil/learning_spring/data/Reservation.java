package com.olmez.lil.learning_spring.data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

import lombok.Data;

@Entity
@Table(name = "RESERVATION")
@Data
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "RESERVATION_ID")
  private long id;

  @Column(name = "ROOM_ID") private long roomId;

  @Column(name = "GUEST_ID") private long guestId;

  @Column(name = "RES_DATE") private Date reservationDate;

}
