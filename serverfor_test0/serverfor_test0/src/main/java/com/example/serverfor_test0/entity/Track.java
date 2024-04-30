package com.example.serverfor_test0.entity;

import lombok.Data;

@Data
public class Track {
    /**
     * 这里注意 命名成Track是不对的 应该是point由于一开始用来返回轨迹数据所以命名错误了  将错就错  倒是注意这是点不是轨迹
     */
    private Integer segmentId;
    private Double lng;
    private Double lat;

}
