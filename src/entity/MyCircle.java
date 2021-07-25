package entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import utilities.Vector;

public class MyCircle implements Entity {

    private GameContainer container;
    private Graphics g;

    private Vector position, destination;
    private Vector velocity;
    private Vector magnitude;

    public final static int DEFAULT_RADIUS = 16;
    public final static int ENTITY_OUTLINE_OFFSET = 6;
    private float radius;
    private float diameter;

    private Color originalBackground;
    private Color background;
    private boolean selected = false;

    public MyCircle(GameContainer container, int x, int y, int radius) {
        this.container = container;
        this.g = container.getGraphics();

        this.position = new Vector(x, y);
        this.radius = radius;
        this.diameter = radius * 2;

        originalBackground = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
                (int) (Math.random() * 255), 255);
        background = originalBackground;

        this.destination = new Vector((int) (Math.random() * container.getWidth()),
                (int) (Math.random() * container.getHeight()));
    }

    public void render() {
        g.setColor(background);
        g.fillOval(position.x - radius, position.y - radius, diameter, diameter);
        g.setColor(Color.red);
        g.drawOval(destination.x - radius - 4, destination.y - radius - 4,
                diameter + 8, diameter + 8);
    }

    public void update() {
        magnitude = Vector.sub(destination, position);
        if(magnitude.getDistance() > .001) {
            magnitude.normalize(Math.min(3, magnitude.getDistance()));
        }
        position.add(magnitude);
    }

    public boolean intersect(Entity entity) {
        return Vector.sub(position, entity.getPosition()).getDistance()
                <= (radius + entity.getRadius());
    }

    public Vector getPosition() {
        return position;
    }

    public Vector getDestination() {
        return destination;
    }

    public float getRadius() {
        return radius;
    }

    public void setBackground(Color color) {
        background = color;
    }

    public void resetBackground() {
        background = originalBackground;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        background = selected ? Color.black : originalBackground;
    }

    public void setDestination(int x, int y) {
        destination.x = x;
        destination.y = y;
    }
}
