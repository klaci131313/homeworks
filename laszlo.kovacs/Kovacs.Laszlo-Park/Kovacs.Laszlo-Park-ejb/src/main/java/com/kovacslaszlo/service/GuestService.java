package com.kovacslaszlo.service;

import com.kovacslaszlo.dto.GuestDTO;
import com.kovacslaszlo.entity.Guest;
import com.kovacslaszlo.entity.Machine;
import com.kovacslaszlo.entity.Park;
import com.kovacslaszlo.service.exception.AlreadyActiveGuestException;
import com.kovacslaszlo.service.exception.GuestIsAlreadyOnMachineException;
import com.kovacslaszlo.service.exception.GuestIsNotOnMachineException;
import com.kovacslaszlo.service.exception.MachineIsFullException;
import com.kovacslaszlo.service.exception.NotEnoughCapitalException;
import com.kovacslaszlo.service.exception.NotInParkException;
import com.kovacslaszlo.service.exception.TooYoungGuestException;
import com.kovacslaszlo.repository.GuestRepository;
import com.kovacslaszlo.repository.MachineRepository;
import com.kovacslaszlo.repository.ParkRepository;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Laci
 */
@Stateless
public class GuestService {

    @Inject
    private GuestRepository guestRepository;
    @Inject
    private MachineRepository machineRepository;
    @Inject
    private ParkRepository parkRepository;

    public Guest createGuest(GuestDTO guestDTO) {
        Guest guest = new Guest(guestDTO.getName(), guestDTO.getAge(), false, guestDTO.getMoney());

        guestRepository.create(guest);
        return guest;
    }

    public Guest getGuest(Long guestId) {
        return guestRepository.find(Guest.class, guestId);
    }

    public Guest deleteGuest(Long guestId) {
        Guest guest = guestRepository.find(Guest.class, guestId);
        guestRepository.delete(Guest.class, guestId);
        return guest;
    }

    public Guest enterParkById(Long guestId, Long parkId) {
        Guest guest = guestRepository.find(Guest.class, guestId);
        Park park = parkRepository.find(Park.class, parkId);

        if (guest.isActive()) {
            throw new AlreadyActiveGuestException();
        }
        if (guest.getMoney() < park.getTicketPrice()) {
            throw new NotEnoughCapitalException();
        }

        Date date = new Date();
        guest.setEntryDate(date);
        int money = guest.getMoney() - park.getTicketPrice();
        guest.setMoney(money);
        guest.setActive(true);

        int capital = park.getCapital() + park.getTicketPrice();
        park.setCapital(capital);

        park.getGuests().add(guest);

        parkRepository.update(park);
        guestRepository.update(guest);
        return guest;

    }

    public Guest enterPark(GuestDTO guestDTO, Long parkId) {
        Guest guest = createGuest(guestDTO);
        return enterParkById(guest.getId(), parkId);
    }

    public Guest exitPark(Long guestId, Long parkId) {
        Park park = parkRepository.find(Park.class, parkId);
        Guest guest = null;
        for (Guest g : park.getGuests()) {
            if (g.getId() == guestId) {
                guest = g;
            }
        }
        if (guest == null) {
            throw new NotInParkException();
        }
        guest.setActive(false);
        guestRepository.update(guest);
        parkRepository.update(park);

        return guest;
    }

    public Guest enterMachine(Long guestId, Long machineId) {
        Guest guest = machineRepository.find(Guest.class, guestId);
        Park park = machineRepository.find(Park.class, machineId);
        Machine machine = machineRepository.find(Machine.class, machineId);

        canUseMachine(guest, machine);

        int money = guest.getMoney() - machine.getTicketPrice();
        guest.setMoney(money);
        int capital = park.getCapital() + machine.getTicketPrice();
        park.setCapital(capital);
        machine.getGuests().add(guest);

        machineRepository.update(machine);
        guestRepository.update(guest);
        return guest;
    }

    public Guest exitMachine(Long guestId, Long machineId) {
        Machine machine = machineRepository.find(Machine.class, machineId);
        Guest guest = machineRepository.find(Guest.class, guestId);
        if (!machine.getGuests().contains(guest)) {
            throw new GuestIsNotOnMachineException();
        }
        machine.getGuests().remove(guest);
        machineRepository.update(machine);
        guestRepository.update(guest);
        return guest;
    }

    public boolean canUseMachine(Guest guest, Machine machine) {
        if (guest.getAge() < machine.getMinimumAge()) {
            throw new TooYoungGuestException();
        }
        if (guest.getMoney() < machine.getTicketPrice()) {
            throw new NotEnoughCapitalException();
        }
        if (machine.getGuests().size() == machine.getCapacity()) {
            throw new MachineIsFullException();
        }
        if (machine.getGuests().contains(guest)) {
            throw new GuestIsAlreadyOnMachineException();
        }
        return true;
    }
}
