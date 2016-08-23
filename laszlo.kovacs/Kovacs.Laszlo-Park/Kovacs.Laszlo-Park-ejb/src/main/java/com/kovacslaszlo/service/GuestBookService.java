package com.kovacslaszlo.service;

import com.kovacslaszlo.dto.Description;
import com.kovacslaszlo.entity.Guest;
import com.kovacslaszlo.entity.GuestBook;
import com.kovacslaszlo.entity.Park;
import com.kovacslaszlo.service.exception.NotInParkException;
import com.kovacslaszlo.repository.GuestBookRepository;
import com.kovacslaszlo.repository.GuestRepository;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Laci
 */
@Stateless
public class GuestBookService {

    @Inject
    private GuestBookRepository repository;
    @Inject
    private GuestRepository guestRepository;
    @Inject
    private GuestRepository parkRepository;

    public GuestBook createGuestBook(Long parkId) {
        GuestBook guestBook = new GuestBook();
        Park park = parkRepository.find(Park.class, parkId);
        guestBook.setPark(park);
        repository.create(guestBook);

        return guestBook;
    }

    public GuestBook getGuestBook(Long guestBookId) {
        return repository.find(GuestBook.class, guestBookId);
    }

    public GuestBook deleteGuestBook(Long guestBookId) {
        GuestBook guestBook = repository.find(GuestBook.class, guestBookId);
        repository.delete(GuestBook.class, guestBookId);
        return guestBook;
    }

    public GuestBook addDescription(Long guestId, Long guestBookId, String text) {
        GuestBook guestBook = repository.find(GuestBook.class, guestBookId);
        Guest guest = guestRepository.find(Guest.class, guestId);
        if (!guestBook.getPark().getGuests().contains(guest)) {
            throw new NotInParkException();
        }

        Description description = new Description();
        description.setDate(new Date());
        description.setText(text);
        description.setGuest(guest);

        guestBook.getDescriptions().add(description);
        repository.update(guestBook);
        return guestBook;
    }
}
