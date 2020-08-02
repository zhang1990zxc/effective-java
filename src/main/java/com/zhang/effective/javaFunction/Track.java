package com.zhang.effective.javaFunction;

import lombok.Data;

/**
 * @Author zhang
 * @Description 专辑中的一直曲目
 * @Date 2020-08-01 14:21
 * @Version 1.0
 **/
@Data
public class Track {

    private String name;

    private Integer length;

    public Track(String name, Integer length) {
        this.name = name;
        this.length = length;
    }
}
