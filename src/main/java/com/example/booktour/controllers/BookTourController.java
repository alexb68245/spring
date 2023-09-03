package com.example.booktour.controllers;

import com.example.booktour.entities.Tour;
import com.example.booktour.services.RequestTourService;
import com.example.booktour.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ComponentScan
@RestController
@RequestMapping("/course")

public class BookTourController {

    @Autowired
    public TourService tourService;

    @Autowired
    public RequestTourService requestTourService;

    @GetMapping("/all")
    public List<Tour> getAllTours(){
        return tourService.getAllTours();
    }

    @PostMapping("/add")
    public void addTours(@RequestParam String name,
                         @RequestParam int duration,
                         @RequestParam int price ){
        Tour tour = new Tour();
        tour.setTourName(name);
        tour.setTourDuration(duration);
        tour.setTourPrice(price);

        tourService.addTour(tour);
    }
    @GetMapping("{name}")
    @ResponseBody
    public ResponseEntity<Tour> getTourByName(@PathVariable String name){
        Tour tour = tourService.getTourByName(name);
        return ResponseEntity.ok(tour);
    }

    @GetMapping("search/{name}")
    @ResponseBody
    public List<Tour> searchToursByName(@PathVariable String name){
        return tourService.searchToursByName(name);
    }


    @DeleteMapping("/delete")
    public ResponseEntity deleteTour(@RequestBody Integer id){
        tourService.deleteTourById(id);
        return ResponseEntity.ok("Tour deleted successfully.");
    }


    @DeleteMapping("/deleteAll")
    public void deleteAllTours(){
        tourService.deleteTours();
    }

}
