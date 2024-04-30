package com.example.serverfor_test0.controller;

import com.example.serverfor_test0.entity.Track;
import com.example.serverfor_test0.mapper.TrackGOMapper;
import com.example.serverfor_test0.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    @Autowired
     private TrackService trackService;
    @GetMapping
     public Map<String,Object> find_track(){
        List<Map<String,Object>> segments = trackService.getAllTracks();
        Map<String,Object> tracksusers= new HashMap<>();
        tracksusers.put("segments",segments);
     return tracksusers;
    }
}
