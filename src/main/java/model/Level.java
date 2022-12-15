package model;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int id;
    private int sizeX;
    private int sizeY;
    private List<String> map = new ArrayList<>();

    public Level() {
    }

    public int getId() {
        return id;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public List<String> getMap() {
        return map;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void setMap(List<String> map) {
        this.map = map;
    }
}
