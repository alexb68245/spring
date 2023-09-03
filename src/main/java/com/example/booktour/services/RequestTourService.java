package com.example.booktour.services;

import com.example.booktour.entities.RequestTour;
import com.example.booktour.repositories.RequestTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RequestTourService {

    @Autowired
    public RequestTourRepository requestTourRepository;

    public boolean getStatusByDate(Date date) {
        RequestTour requestTour = requestTourRepository.findRequestByDate(date);
        return requestTour.isApproved();
    }

    public void addRequest(RequestTour requestTour) {
        List<RequestTour> requestTours = requestTourRepository.findAll();
        for (RequestTour request :
                requestTours) {
            if (requestTourRepository.findRequestByDate(request.getRequestDate()).getRequestDate() != requestTour.getRequestDate()) {
                requestTourRepository.save(requestTour);
            }
        }
    }
}

