package com.paxian;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

    @SuppressWarnings("NullableProblems")
    Optional<Hotel> findById(String id);

    List<Hotel> findByPricePerNightLessThan(int maxPrice);

    @Query(value = "{'address.city' : '?0'}")
    List<Hotel> findByCity(String city);

    @Query(value = "{'address.country' : '?0'}")
    List<Hotel> findByCountry(String country);

    //Complex Query
    @Query(value = "{'pricePerNight': {$lt:100}}")
    List<Hotel> findByPriceLessThanHundred();

    @Query(value = "{$or : [{'reviews.0.rating' : {$gte : 7}}, {'reviews.1.rating' : {$gte : 7}}]}")
    List<Hotel> findByGoodRating();

    @Query(value = "{$and : [{'pricePerNight' : {$lt:100}}, {$or : [{'reviews.0.rating' : {$gte : 7}}, {'reviews.1.rating' : {$gte : 7}}]}]}")
    List<Hotel> findByAllRecommendedWithGoodRatingAndFairPrice();
}
