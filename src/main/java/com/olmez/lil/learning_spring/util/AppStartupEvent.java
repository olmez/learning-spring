package com.olmez.lil.learning_spring.util;

import com.olmez.lil.learning_spring.business.ReservationService;
import com.olmez.lil.learning_spring.business.RoomReservation;

import java.util.Date;
import java.util.List;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent
    implements ApplicationListener<ApplicationReadyEvent> {

    private final ReservationService reservationService;
    private final DateUtils dateUtils;

  public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
    this.reservationService = reservationService;
    this.dateUtils = dateUtils;
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    Date date = this.dateUtils.createDateFromDateString("2022-01-01");
    List<RoomReservation> reservationList = this.reservationService.getRoomReservationForDate(date);
    reservationList.forEach(System.out::println);
  }
}
