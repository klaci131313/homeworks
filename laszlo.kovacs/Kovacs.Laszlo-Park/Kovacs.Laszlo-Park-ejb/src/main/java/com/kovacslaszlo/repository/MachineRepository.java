package com.kovacslaszlo.repository;

import com.kovacslaszlo.entity.Machine;
import java.util.Collection;

/**
 *
 * @author Laci
 */
public class MachineRepository extends EntityRepository {

    public Collection<Machine> getMachineByParkId(Long parkId) {
        return entityManager
                .createQuery("SELECT g FROM Machine g "
                        + "WHERE g.park.id = :parkId ", Machine.class)
                .setParameter("parkId", parkId).getResultList();
    }
}
