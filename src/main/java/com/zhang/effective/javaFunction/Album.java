package com.zhang.effective.javaFunction;

import lombok.Data;

import java.util.List;
import java.util.stream.Stream;

/**
 * @Author zhang
 * @Description 专辑
 * @Date 2020-08-01 14:22
 * @Version 1.0
 **/
@Data
public class Album {

    private String name;

    private Stream<Track> tracks;

    private List<Track> trackList;

    private Stream<Artist> musicians;

    private Artist mainMusician;

}
