package com.zhang.effective.article30_37;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-08-17 17:04
 * @Version 1.0
 **/
public class WeightTable {

    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("175");
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet planet : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", planet, planet.surfaceWeigh(mass));
        }
    }

}
