package model;

import java.awt.*;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y, 2, 2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.drawRect(
                this.getX() + Model.FIELD_CELL_SIZE / 2 - 1,
                this.getY() + Model.FIELD_CELL_SIZE / 2 - 1,
                this.getWidth(),
                this.getHeight());
    }
}
