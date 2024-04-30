package com.example.serverfor_test0.controller;

import com.example.serverfor_test0.entity.Track;
import com.example.serverfor_test0.service.LocationAndroidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locationandroid")
public class LocationAndroidController {
    @Autowired
    private LocationAndroidService locationAndroidService;
    @PostMapping
    public List<Track> getUserLocation(@RequestBody Track AUserLocation){
        List<Track> BUserLocation = locationAndroidService.getUserLocation(AUserLocation);
        return BUserLocation;
    }
}
