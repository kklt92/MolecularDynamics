package cn.mingweihao.MolecularDynamics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;



/**
 * Created by kklt92 on 11/08/2014.
 */
public class Ball {

    public float mass = 0.001f;

    double potential;
    double wellDepth = 2;
    double poDistance = 5;
    double distance;

    int counter;

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
        this.bounds.radius = 10.0f;


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

        force.x = 0;
        force.y = 0;

        for(int i = 0; i < map.balls.size;i++) {
            distance = (double)(map.balls.get(i).pos.dst(this.pos));

            if(distance != Double.NaN && distance != 0) {
                double pd = poDistance / distance;
                //    potential = 4 * wellDepth * (Math.pow(pd, 12) - Math.pow(pd, 6));

                // easy force calculate.

                double f = 4 * wellDepth * (12 * Math.pow(poDistance, 12) / Math.pow(distance, 13)
                                 - 6 * Math.pow(poDistance, 6) / Math.pow(distance, 7));




                           force.x = force.x + (float)(f * (map.balls.get(i).pos.x - this.pos.x) / distance);
                           force.y = force.y + (float)(f * (map.balls.get(i).pos.y - this.pos.y) / distance);
            }

        }


    }

    private void tryMove() {
        pos.x += vel.x;
        pos.y += vel.y;

        if(pos.x > 800) {
            pos.x = pos.x % 800;
        } else if(pos.x < 0) {
            pos.x = 800 + (pos.x % 800);
        }

        if(pos.y > 480) {
            pos.y = pos.y % 480;
        } else if(pos.y < 0) {
            pos.y = 480 + (pos.y % 480);
        }


    }
}
