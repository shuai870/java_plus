package com.example.serverfor_test0.mapper;

import com.example.serverfor_test0.entity.Track;
import com.example.serverfor_test0.entity.TrackAndroid;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationAndroidMapper {
    //找到数据库data表中每个人的最新数据 返回集合
    @Select("select * from data join (select  segmentId,MAX(timestamp) AS max_timestamp FROM data GROUP BY segmentId) AS latest ON data.segmentId = latest.segmentId AND data.timestamp = latest.max_timestamp")
    List<TrackAndroid> getLatestUserLocations();
    //向数据库data表插入一条新的数据
    @Insert("INSERT INTO data (segmentId,warnType, lng, lat) VALUES (#{segmentId},#{warnType}, #{lng}, #{lat})")
    void insertLocation(TrackAndroid trackAndroid);
}
