package com.olmez.lil.learning_spring.business;

import com.olmez.lil.learning_spring.data.Guest;
import com.olmez.lil.learning_spring.data.GuestRepository;
import com.olmez.lil.learning_spring.data.Reservation;
import com.olmez.lil.learning_spring.data.ReservationRepository;
import com.olmez.lil.learning_spring.data.Room;
import com.olmez.lil.learning_spring.data.RoomRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;



@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationForDate(Date date) {
        Iterable<Room> rooms = roomRepository.findAll();

        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });

        List<RoomReservation> roomReservationList = new ArrayList<>();
        for (long id : roomReservationMap.keySet()) {
            roomReservationList.add(roomReservationMap.get(id));
        }

        roomReservationList.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation i1, RoomReservation i2) {
                if (i1.getRoomName().equals(i2.getRoomName())) {
                    return i1.getRoomNumber().compareTo(i2.getRoomNumber());
                }
                return i1.getRoomName().compareTo(i2.getRoomName());
            }
        });

        return roomReservationList;
    }
}
