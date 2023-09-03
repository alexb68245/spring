package com.example.booktour.repositories;

import com.example.booktour.entities.RequestTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface RequestTourRepository extends JpaRepository<RequestTour, Integer> {

   @Query("select '*' from request r where r.requestDate = :requestDate")
    RequestTour findRequestByDate(@Param(value = "requestDate") Date requestDate);
}
