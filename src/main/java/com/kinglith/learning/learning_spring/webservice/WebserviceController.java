package com.kinglith.learning.learning_spring.webservice;

import com.kinglith.learning.learning_spring.business.ReservationService;
import com.kinglith.learning.learning_spring.business.RoomReservation;
import com.kinglith.learning.learning_spring.data.Guest;
import com.kinglith.learning.learning_spring.data.Room;
import com.kinglith.learning.learning_spring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {

    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false)String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public List<Room> getRooms(){
        return this.reservationService.getHotelRooms();
    }

    @RequestMapping(path = "/guests", method = RequestMethod.GET)
    public List<Guest> getHotelGuests(){
        return this.reservationService.getHotelGuests();
    }

    @RequestMapping(path = "/guests", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addHotelGuest(@RequestBody Guest guest){
        this.reservationService.addHotelGuest(guest);
    }
}
