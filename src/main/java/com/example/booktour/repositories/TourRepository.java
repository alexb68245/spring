package com.example.booktour.repositories;

import com.example.booktour.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

    @Query("select '*' from tour t where t.tourName = :tourName")
    Tour findTourByName(@Param(value = "tourName") String tourName);

}
