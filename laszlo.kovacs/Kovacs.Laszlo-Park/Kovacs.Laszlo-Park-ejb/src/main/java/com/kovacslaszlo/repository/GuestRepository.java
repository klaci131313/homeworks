package com.kovacslaszlo.repository;

import com.kovacslaszlo.entity.Guest;
import java.util.Collection;

/**
 *
 * @author Laci
 */
public class GuestRepository extends EntityRepository {

    public Collection<Guest> getGuestByMachineId(Long machineId) {
        return entityManager
                .createQuery("SELECT g FROM Guest g "
                        + "WHERE g.machine.id = :machineId ", Guest.class)
                .setParameter("parkId", machineId).getResultList();
    }
}
