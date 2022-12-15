package model;

import controller.EventListener;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Model {
    private GameObjects gameObjects;
    int currentLevel = 1;
    LevelLoader levelLoader;

    {

            levelLoader = new LevelLoader(Paths.get("./src/main/resources/levels.txt"));
            System.out.println(levelLoader.toString());

    }

    private EventListener eventListener;
    public static final int FIELD_CELL_SIZE = 20;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void restartLevel(int level) {
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void move(Direction direction) {
        Player player = getGameObjects().getPlayer();
        if (checkWallCollision(player, direction)) return;
        if (checkBoxCollisionAndMoveIfAvailable(direction)) return;
        switch (direction) {
            case LEFT: player.move(Model.FIELD_CELL_SIZE * -1, 0); break;
            case RIGHT: player.move(Model.FIELD_CELL_SIZE, 0); break;
            case UP: player.move(0, Model.FIELD_CELL_SIZE * -1); break;
            case DOWN: player.move(0, Model.FIELD_CELL_SIZE); break;
        }
        this.checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) return true;
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        for (Box box : gameObjects.getBoxes()) {
            if (gameObjects.getPlayer().isCollision(box, direction)) {
                for (Box secondBox : gameObjects.getBoxes()) {
                    if (box.isCollision(secondBox, direction)) {
                        return true;
                    } else if (checkWallCollision(box, direction)) {
                        return true;
                    }
                }
                switch (direction) {
                    case RIGHT: box.move(Model.FIELD_CELL_SIZE, 0); break;
                    case LEFT: box.move(Model.FIELD_CELL_SIZE * -1, 0); break;
                    case DOWN: box.move(0, Model.FIELD_CELL_SIZE); break;
                    case UP: box.move(0, Model.FIELD_CELL_SIZE * -1); break;
                }
            }

        }
        return false;
    }

    public void checkCompletion() {
        Set<Boolean> isHomes = new HashSet<>();
        for (Home home : getGameObjects().getHomes()) {
            boolean isHome = false;
            for (Box box : gameObjects.getBoxes()) {
                if (home.getX() == box.getX() && home.getY() == box.getY()) isHome = true;
            }
            isHomes.add(isHome);
        }
        if (!isHomes.contains(false)) eventListener.levelCompleted(this.currentLevel);
    }
}
