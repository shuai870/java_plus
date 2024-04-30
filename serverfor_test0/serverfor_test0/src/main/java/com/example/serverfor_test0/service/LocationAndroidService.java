package com.example.serverfor_test0.service;

import com.example.serverfor_test0.entity.Track;
import com.example.serverfor_test0.entity.TrackAndroid;
import com.example.serverfor_test0.mapper.LocationAndroidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationAndroidService {
        @Autowired
        private LocationAndroidMapper locationAndroidMapper;
        public List<TrackAndroid> getUserLocation(TrackAndroid AUserLocation){
            locationAndroidMapper.insertLocation(AUserLocation);
            List<TrackAndroid> UserLocation = locationAndroidMapper.getLatestUserLocations(); //这里已经拿到所有用户的最新轨迹点 接下来需要去掉刚刚传进来的新的轨迹点
            int A = AUserLocation.getSegmentId();
            for(TrackAndroid trackAndroid : UserLocation){
                int B = trackAndroid.getSegmentId();
                if(A == B){
                    UserLocation.remove(trackAndroid);
                    break;
                }
            }
            return UserLocation;
        }
}
