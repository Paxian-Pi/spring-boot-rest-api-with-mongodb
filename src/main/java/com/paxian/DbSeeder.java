package com.paxian;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    public HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Hotel sheraton = new Hotel(
                "Sheraton",
                180,
                new Address("Lagos", "Nigeria"),
                Arrays.asList(
                        new Review("Matt", 8, false),
                        new Review("Regina", 7, true),
                        new Review("Stephen", 5, true),
                        new Review("Martina", 3, false)
                )
        );

        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Grand Budapest", "Romania"),
                Collections.singletonList(
                        new Review("Teddy", 9, true)
                )
        );

        Hotel intercontinental = new Hotel(
                "Intercontinental",
                200,
                new Address("Lagos", "Nigeria"),
                new ArrayList<>()
        );

        // drop all hotels
        this.hotelRepository.deleteAll();

        //add our hotels to the database
        List<Hotel> hotels = Arrays.asList(sheraton, marriot, ibis, intercontinental);
        this.hotelRepository.saveAll(hotels);
    }
}
