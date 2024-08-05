package com.kinglith.learning.learning_spring.business;

import com.kinglith.learning.learning_spring.data.Guest;
import com.kinglith.learning.learning_spring.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests(){
        List<Guest> guestList = new ArrayList<>();
        Iterable<Guest> guests = this.guestRepository.findAll();
        guests.forEach(guest -> {
            guestList.add(guest);
        });
        return guestList;
    }
}
