package com.example.demo.web;

import com.example.demo.business.service.ReservationService;
import com.example.demo.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;


@Controller
@RequestMapping("/guests")
public class GuestWebController {
    public final ReservationService reservationService;

    @Autowired
    public GuestWebController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getGuests(Model model){
        List<Guest> guests = this.reservationService.getHotelGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }
}
