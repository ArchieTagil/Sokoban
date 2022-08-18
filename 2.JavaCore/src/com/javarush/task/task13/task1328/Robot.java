package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot {
    private String name;
    private int hits;

    public Robot(String name, int hits) {
        this.name = name;
        this.hits = hits;
    }
    public String getName() {
        return name;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getHits() {
        return hits;
    }
}
