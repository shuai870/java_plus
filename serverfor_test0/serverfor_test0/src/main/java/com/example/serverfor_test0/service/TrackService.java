package com.example.serverfor_test0.service;

import com.example.serverfor_test0.entity.Track;
import com.example.serverfor_test0.mapper.TrackGOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TrackService {
    @Autowired
    private TrackGOMapper trackGOMapper;

    public List<Map<String,Object>> getAllTracks(){
        List<Map<String,Object>> allTracks = new ArrayList<>();
        List<Integer> countUser = trackGOMapper.countUser();
        Iterator<Integer> iterator = countUser.iterator();
        while(iterator.hasNext()){
            int id = iterator.next();
            List<Track> tracks = trackGOMapper.points(id);
            Map<String,Object> trackInfo = new HashMap<>();
            trackInfo.put("segmentId",id);
            List<Map<String,Double>> points = new ArrayList<>();
            Iterator<Track> iteratorAtracks = tracks.iterator();
            while(iteratorAtracks.hasNext()){
                Track uptrackPoint = iteratorAtracks.next();
                Map<String,Double> point = new HashMap<>();
                point.put("lng",uptrackPoint.getLng());
                point.put("lat",uptrackPoint.getLat());
                points.add(point);
            }
            trackInfo.put("points",points);
            allTracks.add(trackInfo);
        }
             return allTracks;
    }
}
