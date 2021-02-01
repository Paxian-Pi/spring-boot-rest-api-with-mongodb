package com.paxian;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    public HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll() {
        return this.hotelRepository.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> modifyHotel(@RequestBody Hotel hotel){
        this.hotelRepository.insert(hotel);
        return new ResponseEntity<>("Hotel object Inserted successfully!", HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> update(@RequestBody Hotel hotel){
        this.hotelRepository.save(hotel);
        return new ResponseEntity<>("Hotel has been updated!", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> delete(@PathVariable("id") Hotel id){
        this.hotelRepository.delete(id);
        return new ResponseEntity<>("Deleted successfully!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Hotel> getById(@PathVariable("id") String id){
        return this.hotelRepository.findById(id);
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        return this.hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city) {
        return this.hotelRepository.findByCity(city);
    }

    @GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country) {
        return this.hotelRepository.findByCountry(country);
    }

    @GetMapping("/goodPrice")
    public List<Hotel> getByPriceLessThanHundred(){
        return this.hotelRepository.findByPriceLessThanHundred();
    }

    @GetMapping("/goodRating")
    public List<Hotel> getByGoodRating(){
        return this.hotelRepository.findByGoodRating();
    }

    @GetMapping("/recommended_with_good_rating_and_fair_price")
    public List<Hotel> getAllRecommended(){
        return this.hotelRepository.findByAllRecommendedWithGoodRatingAndFairPrice();
    }

    /*@GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country){
        // create a query class (QHotel)
        QHotel qHotel = new QHotel("hotel");

        // using the query class we can create the filters
        BooleanExpression filterByCountry = qHotel.address.country.eq(country);

        // we can then pass the filters to the findAll() method
        return (List<Hotel>) this.hotelRepository.findAll(filterByCountry);
    }

    @GetMapping("/recommended")
    public List<Hotel> getRecommended(){
        final int maxPrice = 100;
        final int minRating = 7;

        // create a query class (QHotel)
        QHotel qHotel = new QHotel("hotel");

        // using the query class we can create the filters
        BooleanExpression filterByPrice = qHotel.pricePerNight.lt(maxPrice);
        BooleanExpression filterByRating = qHotel.reviews.any().rating.gt(minRating);

        // we can then pass the filters to the findAll() method
        return (List<Hotel>) this.hotelRepository.findAll(filterByPrice.and(filterByRating));
    }*/
}
