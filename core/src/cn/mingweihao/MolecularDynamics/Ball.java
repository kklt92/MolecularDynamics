package cn.mingweihao.MolecularDynamics;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by kklt92 on 11/08/2014.
 */
public class Ball {

    public float mass = 1f;

    double potential;
    double wellDepth;
    double poDistance;
    double distance;

    Map map;

    Vector2 pos = new Vector2();
    Vector2 accel = new Vector2();
    Vector2 vel = new Vector2();
    Vector2 force = new Vector2();
    public Circle bounds = new Circle();


    public Ball(Map map, float x, float y) {
        this.map = map;
        this.pos.x = x;
        this.pos.y = y;
        this.bounds.x = x;
        this.bounds.y = y;
        this.bounds.radius = 1.0f;


    }

    public void update(float deltaTime) {
        potentialForce();

        accel.x = force.x / mass;
        accel.y = force.y / mass;
        accel.scl(deltaTime);

        vel.add(accel.x, accel.y);

        vel.scl(deltaTime);
        tryMove();
        vel.scl(1.0f / deltaTime);
    }

    private void potentialForce() {


        double pd = poDistance / distance;
        potential = 4 * wellDepth * (Math.pow(pd, 12) - Math.pow(pd, 6));

        // easy force calculate.
        double f = 4 * wellDepth * (12 * Math.pow(poDistance, 12) / Math.pow(distance, 13)
                - 6 * Math.pow(poDistance, 6) / Math.pow(distance, 7));
        force.x = 5;
        force.y = 1;
    }

    private void tryMove() {
        pos.x += vel.x;
        pos.y += vel.y;



    }
}
