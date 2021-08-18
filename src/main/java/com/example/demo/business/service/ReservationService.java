package com.example.demo.business.service;

import com.example.demo.business.domain.RoomReservation;
import com.example.demo.data.entity.Guest;
import com.example.demo.data.entity.Reservation;
import com.example.demo.data.entity.Room;
import com.example.demo.data.repository.GuestRepository;
import com.example.demo.data.repository.ReservationRepository;
import com.example.demo.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;


    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
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

        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }
        //this is for sorting by alphabetical order in place of room number
        roomReservations.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation roomReservation, RoomReservation t1) {
                if (roomReservation.getRoomName() == t1.getRoomName()) {
                    return roomReservation.getRoomNumber().compareTo(t1.getRoomNumber());
                }
                return roomReservation.getRoomName().compareTo(t1.getRoomName());
            }
        });
        return roomReservations;
    }
        //this is for sorting hotelGuests by their last names and firstname
        public List<Guest> getHotelGuests(){
            Iterable<Guest> guests = this.guestRepository.findAll();
            List<Guest> guestList = new ArrayList<>();
            guests.forEach(guest -> {guestList.add(guest);});
            guestList.sort(new Comparator<Guest>() {
                @Override
                public int compare(Guest guest, Guest t1) {
                    if (guest.getLastName() == t1.getLastName()){
                        return guest.getFirstName().compareTo(t1.getFirstName());
                    }
                    return guest.getLastName().compareTo(t1.getLastName());
                }
            });
            return guestList;



    }
}
