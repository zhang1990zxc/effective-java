package com.zhang.effective.javaFunction;

import lombok.Data;

import java.util.stream.Stream;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-08-01 14:30
 * @Version 1.0
 **/
@Data
public class Artist {

    private String name;

    private Stream<String> members;

    private String origin;

    private String nationality;

    private boolean solo;

}
