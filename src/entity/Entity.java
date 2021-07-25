package entity;

import org.newdawn.slick.Color;
import utilities.Vector;

public interface Entity {

    public void render();

    public void update();

    public boolean intersect(Entity entity);

    public Vector getPosition();

    public Vector getDestination();

    public void setBackground(Color color);

    public void resetBackground();

    public void setSelected(boolean selected);

    public void setDestination(int x, int y);

    public float getRadius();

}