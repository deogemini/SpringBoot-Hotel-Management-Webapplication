package com.example.demo;

import com.example.demo.data.entity.Guest;
import com.example.demo.data.entity.Reservation;
import com.example.demo.data.entity.Room;
import com.example.demo.data.repository.GuestRepository;
import com.example.demo.data.repository.ReservationRepository;
import com.example.demo.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@RestController
//	@RequestMapping("/rooms")
//	public class RoomController{
//		@Autowired
//		private RoomRepository roomRepository;
//
//		@GetMapping
//		public Iterable<Room> getRooms(){
//			return this.roomRepository.findAll();
//		}
//	}
//
//	@RestController
//	@RequestMapping("/guest")
//	public class GuestController{
//		@Autowired
//		private GuestRepository guestRepository;
//
//		@GetMapping
//		public Iterable<Guest> getGuests(){
//			return this.guestRepository.findAll();
//		}
//	}
//
//	@RestController
//	@RequestMapping("/reservations")
//	public class ReservationController{
//		@Autowired
//		private ReservationRepository reservationRepository;
//
//		@GetMapping
//		public Iterable<Reservation> getReservations(){
//			return  this.reservationRepository.findAll();
//		}
//	}

}
