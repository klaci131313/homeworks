package com.kovacslaszlo.service;

import com.kovacslaszlo.dto.MachineDTO;
import com.kovacslaszlo.entity.Guest;
import com.kovacslaszlo.entity.Machine;
import com.kovacslaszlo.entity.Park;
import com.kovacslaszlo.enums.MachineType;
import com.kovacslaszlo.service.exception.NotEmptyMachineException;
import com.kovacslaszlo.service.exception.NotEnoughAreaException;
import com.kovacslaszlo.service.exception.NotEnoughCapitalException;
import com.kovacslaszlo.repository.MachineRepository;
import com.kovacslaszlo.repository.ParkRepository;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Laci
 */
@Stateless
public class MachineService {

    @Inject
    private MachineRepository machineRepository;
    @Inject
    private ParkRepository parkRepository;

    public Machine createMachine(MachineDTO machineDTO) {
        Machine machine = new Machine("name", 0, 0, 0, 0, MachineType.CHUTE, 0);
        machine.setName(machineDTO.getName());
        machine.setSize(machineDTO.getSize());
        machine.setPrice(machineDTO.getPrice());
        machine.setTicketPrice(machineDTO.getTicketPrice());
        machine.setCapacity(machineDTO.getCapacity());
        machine.setType(machineDTO.getType());
        machine.setMinimumAge(machineDTO.getMinimumAge());
        machine.setActive(false);

        machineRepository.create(machine);
        return machine;
    }

    public Machine addToPark(MachineDTO machineDTO, Long parkId) {
        Park park = parkRepository.find(Park.class, parkId);
        Machine machine = createMachine(machineDTO);
        if (park.getCapital() < machine.getPrice()) {
            throw new NotEnoughCapitalException();
        }
        if (park.getArea() < machine.getSize()) {
            throw new NotEnoughAreaException();
        }
        machine.setActive(true);
        park.getMachines().add(machine);
        int area = park.getArea() - machine.getSize();
        park.setArea(area);
        int capital = park.getCapital() - machine.getPrice();
        park.setCapital(capital);
        park.getMachines().add(machine);

        parkRepository.update(park);
        machineRepository.update(machine);
        return machine;
    }

    public Machine removeToPark(Long machineId, Long parkId) {
        Park park = parkRepository.find(Park.class, parkId);
        Machine machine = machineRepository.find(Machine.class, machineId);
        if (!machine.getGuests().isEmpty()) {
            throw new NotEmptyMachineException();
        }
        int capital = park.getCapital() + machine.getPrice();
        park.setCapital(capital);
        int area = park.getArea() + machine.getSize();
        park.setArea(area);
        machine.setActive(false);
        park.getMachines().remove(machine);
        parkRepository.update(park);
        machineRepository.update(machine);
        return machine;
    }

    public Machine getMachine(Long machineId) {
        return machineRepository.find(Machine.class, machineId);
    }

    public Collection<Guest> getGuests(Long machineId) {
        Machine machine = machineRepository.find(Machine.class, machineId);
        return machine.getGuests();
    }

    public Machine deleteMachine(Long machineId) {
        Machine machine = machineRepository.find(Machine.class, machineId);
        machineRepository.delete(Machine.class, machineId);
        return machine;
    }
}
