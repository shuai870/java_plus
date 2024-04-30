package com.example.serverfor_test0.service;

import com.example.serverfor_test0.entity.Track;
import com.example.serverfor_test0.mapper.LocationAndroidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationAndroidService {
        @Autowired
        private LocationAndroidMapper locationAndroidMapper;
        public List<Track> getUserLocation(Track AUserLocation){
            locationAndroidMapper.insertLocation(AUserLocation);
            List<Track> UserLocation = locationAndroidMapper.getLatestUserLocations(); //这里已经拿到所有用户的最新轨迹点 接下来需要去掉刚刚传进来的新的轨迹点
            int A = AUserLocation.getSegmentId();
            for(Track track : UserLocation){
                int B = track.getSegmentId();
                if(A == B){
                    UserLocation.remove(track);
                    break;
                }
            }
            return UserLocation;
        }
}
