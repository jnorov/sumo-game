package utilities;

public class Vector {

    public float x;
    public float y;

    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static Vector add(Vector one, Vector two) {
        return new Vector(one.x + two.x, one.y + two.y);
    }

    public static Vector sub(Vector one, Vector two) {
        return new Vector(one.x - two.x, one.y - two.y);
    }

    public void add(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    public void sub(Vector vector) {
        this.x -= vector.x;
        this.y -= vector.y;
    }

    public void multiply(float scalar) {
        x *= scalar;
        y *= scalar;
    }

    public float getDistance() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        float distance = getDistance();
        x /= distance;
        y /= distance;
    }

    public void normalize(float scalar) {
        float distance = getDistance();
        x = (x / distance) * scalar;
        y = (y / distance) * scalar;
    }

}