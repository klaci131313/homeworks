package com.kovacslaszlo.service;

import com.kovacslaszlo.dto.ParkDTO;
import com.kovacslaszlo.entity.Guest;
import com.kovacslaszlo.entity.Machine;
import com.kovacslaszlo.entity.Park;
import com.kovacslaszlo.repository.ParkRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Laci
 */
@Stateless
public class ParkService {

    @Inject
    ParkRepository repository;

    public Park createPark(ParkDTO parkDTO) {
        Park park = new Park(parkDTO.getName(), parkDTO.getAddress(),
                parkDTO.getCapital(), parkDTO.getArea(), parkDTO.getTicketPrice());

        repository.create(park);
        return park;
    }

    public Park updatePark(ParkDTO parkDTO, Long parkId) {
        Park park = repository.find(Park.class, parkId);
        park.setAddress(parkDTO.getAddress());
        park.setArea(parkDTO.getArea());
        park.setCapital(park.getCapital());
        park.setName(parkDTO.getName());
        park.setTicketPrice(parkDTO.getTicketPrice());

        repository.update(park);
        return park;
    }

    public Park deletePark(Long parkId) {
        Park park = repository.find(Park.class, parkId);
        repository.delete(Park.class, parkId);
        return park;
    }

    public Collection<Guest> getAllGuest(Long parkId) {
        Park park = repository.find(Park.class, parkId);
        return park.getGuests();
    }

    public Collection<Guest> getActiveGuest(Long parkId) {
        Park park = repository.find(Park.class, parkId);
        List<Guest> list = new ArrayList();
        for (Guest guest : park.getGuests()) {
            if (guest.isActive()) {
                list.add(guest);
            }
        }
        return list;
    }

    public Park getPark(Long parkId) {
        return repository.find(Park.class, parkId);
    }

    public Collection<Machine> getAllMachine(Long parkId) {
        Park park = repository.find(Park.class, parkId);
        return park.getMachines();
    }

    public Collection<Machine> getActiveMachine(Long parkId) {
        Park park = repository.find(Park.class, parkId);
        List<Machine> list = new ArrayList<>();
        for(Machine machine : park.getMachines()) {
            if (machine.isActive()) {
                list.add(machine);
            }
        }
        return list;
    }
}
