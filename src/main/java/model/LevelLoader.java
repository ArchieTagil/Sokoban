package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        List<Level> loadedLevels = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            while (reader.ready()) {
                String maze;
                if ((maze = reader.readLine()).contains("Maze")) {
                    Level tmpLevel = new Level();
                    List<String> map = new ArrayList<>();

                    String[] mazeLine = maze.split(" ");
                    tmpLevel.setId(Integer.parseInt(mazeLine[1]));

                    reader.readLine();
                    String sizeX = reader.readLine();
                    tmpLevel.setSizeX(Integer.parseInt(sizeX.substring(sizeX.lastIndexOf(" ") + 1)));
                    String sizeY = reader.readLine();
                    tmpLevel.setSizeY(Integer.parseInt(sizeY.substring(sizeY.lastIndexOf(" ") + 1)));

                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    for (int i = 0; i < tmpLevel.getSizeY(); i++) {
                        map.add(reader.readLine());
                    }
                    tmpLevel.setMap(map);
                    loadedLevels.add(tmpLevel);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Level currentLoadedLevel;
        if (level > 60) currentLoadedLevel = loadedLevels.get(level % 60 - 1);
        else currentLoadedLevel = loadedLevels.get(level - 1);
        List<String> map = currentLoadedLevel.getMap();
        int y = Model.FIELD_CELL_SIZE / 2;
        for (String str : map) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'X') walls.add(new Wall(Model.FIELD_CELL_SIZE / 2 + Model.FIELD_CELL_SIZE * i, y));
                if (chars[i] == '.') homes.add(new Home(Model.FIELD_CELL_SIZE / 2 + Model.FIELD_CELL_SIZE * i, y));
                if (chars[i] == '*') boxes.add(new Box(Model.FIELD_CELL_SIZE / 2 + Model.FIELD_CELL_SIZE * i, y));
                if (chars[i] == '@') player = new Player(Model.FIELD_CELL_SIZE / 2 + Model.FIELD_CELL_SIZE * i, y);
            }
            y = y + Model.FIELD_CELL_SIZE;
        }
        System.out.println(" ");
        return new GameObjects(walls, boxes, homes, player);
    }
}
