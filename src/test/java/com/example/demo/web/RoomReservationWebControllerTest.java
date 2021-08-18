package com.example.demo.web;

import com.example.demo.business.domain.RoomReservation;
import com.example.demo.business.service.ReservationService;
import org.junit.Test;
import org.junit.*;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RoomReservationWebContoller.class)
public class RoomReservationWebControllerTest {
    @MockBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getReservations() throws Exception{
        String dateString = "2020-01-01";
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = new ArrayList<>();
        RoomReservation roomReservation = new RoomReservation(); 
        roomReservation.setLastName("Unit");
        roomReservation.setFirstName("Junit");
        roomReservation.setDate(date);
        roomReservation.setGuestId(1);
        roomReservation.setRoomId(100);
        roomReservation.setRoomName("Junit Room");
        roomReservation.setRoomNumber("J1");
        roomReservations.add(roomReservation);
        given(reservationService.getRoomReservationsForDate(date)).willReturn(roomReservations);

        this.mockMvc.perform(get("/reservations?date=2020-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Unit, Junit")));



    }
}
