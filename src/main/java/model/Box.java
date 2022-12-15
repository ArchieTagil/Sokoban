package model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(153, 102, 0));
        graphics.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        graphics.drawLine(
                this.getX(),
                this.getY(),
                this.getX() + Model.FIELD_CELL_SIZE,
                this.getY() + Model.FIELD_CELL_SIZE);
        graphics.drawLine(
                this.getX() + Model.FIELD_CELL_SIZE,
                this.getY(),
                this.getX(),
                this.getY() + Model.FIELD_CELL_SIZE);

    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
