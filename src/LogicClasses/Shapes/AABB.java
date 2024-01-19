package LogicClasses.Shapes;

public class AABB {

    public float x, y, w, h;

    public AABB(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public boolean intersects(AABB other) {
        if (x + w > other.x && x < other.x + other.w && y + h > other.y && y < other.y + other.h) {
            return true;
        }
        return false;
    }

    public boolean contains(float x, float y) {
        if (x > this.x && x < this.x + w && y > this.y && y < this.y + h) {
            return true;
        }
        return false;
    }

    public boolean intersects(Circle other) {

        float distanceX = Math.abs(x - other.x);
        float distanceY = Math.abs(y - other.y);

        if (distanceX > (w / 2 + other.r)) {
            return false;
        }
        if (distanceY > (h / 2 + other.r)) {
            return false;
        }

        if (distanceX <= (w / 2)) {
            return true;
        }
        if (distanceY <= (h / 2)) {
            return true;
        }

        float cornerDistance_sq = (float) (Math.pow(distanceX - w / 2, 2) + Math.pow(distanceY - h / 2, 2));

        return (cornerDistance_sq <= Math.pow(other.r, 2));
    }

}
