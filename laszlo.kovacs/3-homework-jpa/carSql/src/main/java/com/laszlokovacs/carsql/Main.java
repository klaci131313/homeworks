package com.laszlokovacs.carsql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Laci
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    private Main() {
        //Private constructor
    }

    public static void main(String[] args) {

        String d = "Diesel";
        Date date = new Date();

        List<String> sparePartsList1 = new ArrayList<>();
        List<String> sparePartsList2 = new ArrayList<>();
        List<String> sparePartsList3 = new ArrayList<>();
        sparePartsList1.add("Two spare wheel");
        sparePartsList1.add("One windscreen");
        sparePartsList2.add("Two spare wheel");
        sparePartsList2.add("One mudguard ");
        sparePartsList2.add("One switch");
        sparePartsList3.add("One engine");
        sparePartsList3.add("Two mudguard");
        sparePartsList3.add("One windscreen");
        sparePartsList3.add("Four spare wheel");

        Camion camion1 = new Camion(true, 2, d, sparePartsList1, 6000, Type.MAN);
        Camion camion2 = new Camion(true, 2, d, sparePartsList2, 11000, Type.BMW);
        Camion camion3 = new Camion(false, 4, d, sparePartsList2, 3500, Type.RENAULT);
        Camion camion4 = new Camion(true, 4, d, sparePartsList1, 4000, Type.MAN);
        PersonalCar personalCar1 = new PersonalCar("Black", 5, d, sparePartsList1, 4000, Type.BMW);
        PersonalCar personalCar2 = new PersonalCar("Red", 5, "diesel", sparePartsList3, 3500, Type.MAZDA);
        Sedan sedan1 = new Sedan(5, "Black", 4, d, sparePartsList3, 4500, Type.HONDA);
        Sedan sedan2 = new Sedan(5, "White", 4, d, sparePartsList3, 2500, Type.RENAULT);
        Sedan sedan3 = new Sedan(4, "Green", 5, d, sparePartsList2, 6500, Type.AUDI);
        Sedan sedan4 = new Sedan(4, "Red", 5, d, sparePartsList1, 8000, Type.MAZDA);

        List<Car> carList1 = new ArrayList<>();
        List<Car> carList2 = new ArrayList<>();
        List<Car> carList3 = new ArrayList<>();

        carList1.add(camion1);
        carList1.add(camion2);
        carList1.add(sedan1);
        carList2.add(camion3);
        carList2.add(camion4);
        carList2.add(sedan2);
        carList2.add(personalCar1);
        carList3.add(personalCar2);
        carList3.add(sedan3);
        carList3.add(sedan4);

        Owner owner1 = new Owner(date, "John", carList1);
        Owner owner2 = new Owner(date, "Joey", carList2);
        Owner owner3 = new Owner(date, "Noe", carList3);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloCar");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(owner1);
        em.persist(owner2);
        em.persist(owner3);

        em.persist(camion1);
        em.persist(camion2);
        em.persist(camion3);
        em.persist(camion4);
        em.persist(personalCar1);
        em.persist(personalCar2);
        em.persist(sedan1);
        em.persist(sedan2);
        em.persist(sedan3);
        em.persist(sedan4);

        tx.commit();

        TypedQuery<Car> cars1 = em.createNamedQuery("Car.findCar", Car.class);
        cars1.setParameter("param1", Type.BMW);

        TypedQuery<Car> cars2 = em.createNamedQuery("Car.findExpensiveCars", Car.class);
        cars2.setParameter("param2", 5000);

        TypedQuery<Camion> cars3 = em.createNamedQuery("Camion.findNumberOfSeats", Camion.class);
        cars3.setParameter("param3", 2);

        TypedQuery<Camion> cars4 = em.createNamedQuery("Camion.findWithTrailer", Camion.class);
        cars4.setParameter("param4", true);

        TypedQuery<Sedan> cars5 = em.createNamedQuery("Sedan.findDoors", Sedan.class);
        cars5.setParameter("param5", 4);

        LOG.log(Level.INFO, "{0}", "BMW: ");
        writtenCars(cars1.getResultList());
        LOG.log(Level.INFO, "{0}", "Expensive cars: ");
        writtenCars(cars2.getResultList());
        LOG.log(Level.INFO, "{0}", "Camion with 2 seats: ");
        writtenCars(cars3.getResultList());
        LOG.log(Level.INFO, "{0}", "Camions with trailer: ");
        writtenCars(cars4.getResultList());
        LOG.log(Level.INFO, "{0}", "Sedans with 4 doors: ");
        writtenCars(cars5.getResultList());

        em.close();
        emf.close();

    }

    public static void writtenCars(List<? extends Car> carList) {
        for (Car c : carList) {
            LOG.log(Level.INFO, "{0}", c.toString());
        }
    }
}
