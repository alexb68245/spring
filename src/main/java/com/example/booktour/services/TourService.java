package com.example.booktour.services;

import com.example.booktour.entities.Tour;
import com.example.booktour.repositories.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TourService {

    public TourRepository tourRepository;

    public TourService(TourRepository tourRepository){
        this.tourRepository = tourRepository;
    }

    public List<Tour> getAllTours(){
        return tourRepository.findAll();
    }

    public Tour getTourByName(String tourName){
        return tourRepository.findTourByName(tourName);
    }

    public Optional getTourById(int id){
        return tourRepository.findById(id);
    }

    public void addTour(Tour tour){
        List<Tour> tours = tourRepository.findAll();
        if (tours.isEmpty()){
            tourRepository.save(tour);
        }else {
            for (Tour tour1 : tours) {
                if (tour1.getTourName() != tour.getTourName()){
                    tourRepository.save(tour);
                }
            }
        }

    }

    public void  deleteTourById(int id){
        tourRepository.deleteById(id);
    }

    public void deleteTours(){
        tourRepository.deleteAll();
    }
}
