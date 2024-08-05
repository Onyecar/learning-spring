package com.kinglith.learning.learning_spring.web;

import com.kinglith.learning.learning_spring.business.GuestService;
import com.kinglith.learning.learning_spring.business.RoomReservation;
import com.kinglith.learning.learning_spring.data.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model){
        List<Guest> guests = this.guestService.getGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }
}
