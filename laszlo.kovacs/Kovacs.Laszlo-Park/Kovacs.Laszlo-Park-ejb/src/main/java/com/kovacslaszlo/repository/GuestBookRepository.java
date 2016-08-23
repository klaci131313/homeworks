package com.kovacslaszlo.repository;

import com.kovacslaszlo.dto.Description;
import java.util.Collection;

/**
 *
 * @author Laci
 */
public class GuestBookRepository extends EntityRepository {

    public Collection<Description> getGuestDescriptions(Long guestId) {
        return entityManager
                .createQuery("SELECT g.descriptions FROM GuestBook g "
                        + "WHERE g.descriptions.guest.id =:guestId"
                        + " AND g = g.park.guestBook ", Description.class)
                .setParameter("parkId", guestId).getResultList();
    }

    public Collection<Description> getAllDescriptionsInPark(Long parkId) {
        return entityManager
                .createQuery("SELECT g.descriptions FROM GuestBook g "
                        + "WHERE g.park.id=:parkId ", Description.class)
                .setParameter("parkId", parkId).getResultList();
    }
}
