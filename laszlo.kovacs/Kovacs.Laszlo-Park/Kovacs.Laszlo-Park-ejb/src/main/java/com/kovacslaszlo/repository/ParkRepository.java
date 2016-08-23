package com.kovacslaszlo.repository;

/**
 *
 * @author Laci
 */
public class ParkRepository extends EntityRepository {

    public Long countIdleGuests(Long parkId) {
        return entityManager
                .createQuery("SELECT COUNT(g.id) FROM Guest g WHERE "
                        + "g.park.id = :parkId AND g.machine IS NULL"
                        + " AND g.active = TRUE", Long.class)
                .setParameter("parkId", parkId).getSingleResult();
    }
}
