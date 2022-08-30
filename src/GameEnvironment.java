import java.util.ArrayList;
/**
 * GameEnvironment.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class GameEnvironment {
    private ArrayList<Collidable> listCollidable;
    /**
     * Constructor.
     */
    public GameEnvironment() {
        this.listCollidable = new ArrayList<Collidable>(500);
    }
    // add the given collidable to the environment.
    /**
     * @param c - the new collidable to add
     */
    public void addCollidable(Collidable c) {
        this.listCollidable.add(c);
    }
    /**
     * @param c - the collidable to remove
     */
    public void remCollidable(Collidable c) {
        this.listCollidable.remove(c);
    }
    /**
     * @return the list of Collidables.
     */
    public ArrayList<Collidable> getListCollidable() {
        return this.listCollidable;
    }
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    /**
     * @param trajectory - the line of ball direction
     * @return CollisionInfo of the closest Collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        double[] arr = new double[this.listCollidable.size()];
        //get all collisions distances into an array
        for (int i = 0; i < this.listCollidable.size(); i++) {
            if (trajectory.closestIntersectionToStartOfLine(this.listCollidable.get(i).getCollisionRectangle())
                    != null) {
                arr[i] = trajectory.start().distance(trajectory.
                        closestIntersectionToStartOfLine(this.listCollidable.get(i).getCollisionRectangle()));
            } else {
                arr[i] = Integer.MAX_VALUE;
            }
        }

        double min = arr[0];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min && arr[i] != -2) {
                min = arr[i];
                index = i;
            }
        }
        if (index != -1) {
            CollisionInfo info = new CollisionInfo(trajectory.
                    closestIntersectionToStartOfLine(this.listCollidable.get(index).
                            getCollisionRectangle()), this.listCollidable.get(index));
            return info;
        }
        return null;
    }

}