package com.example.serverfor_test0.mapper;

import com.example.serverfor_test0.entity.Track;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TrackGOMapper {
    @Select("select id from sys_user")
    List<Integer> countUser();

    @Select("select segmentId,lng,lat from data where segmentId =#{id} order by timestamp ASC")
    List<Track> points(int id);
}
