package cn.mingweihao.MolecularDynamics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;




/**
 * Created by kklt92 on 11/08/2014.
 */
public class Map {

    final static int ballNum = 30;

    public Rectangle outbounds = new Rectangle();
    public Array<Ball> balls = new Array<Ball>();
    public Array<Vector2> ballPos = new Array<Vector2>();
    public Array<Vector2> ballVel = new Array<Vector2>();

    private double distance;
    private double force;

    public Map() {
        load();
    }

    private void load() {
        for(int i = 0; i < ballNum; i++) {
            Ball ball = new Ball(this, (float)(Math.random() * 500), (float)(Math.random() * 480));

            balls.add(ball);
        }


    }

    public void update(float deltaTime) {
        engine();
        for(int i = 0; i < balls.size; i++) {
            balls.get(i).update(deltaTime);

        }
    }

    private void engine() {
        for(int i = 0; i<balls.size; i++) {
            balls.get(i).force.x = 0;
            balls.get(i).force.y = 0;
        }
        for(int i = 0; i<balls.size; i++) {
            for(int j = i+1; j<balls.size; j++) {
                distance = balls.get(i).pos.dst(balls.get(j).pos);
                force = 4 * balls.get(i).wellDepth * (12 * Math.pow(balls.get(i).poDistance, 12) / Math.pow(distance, 13)
                        - 6 * Math.pow(balls.get(i).poDistance, 6) / Math.pow(distance, 7));
                balls.get(i).force.x = balls.get(i).force.x + (float)(force * (balls.get(j).pos.x - balls.get(i).pos.x) / distance);
                balls.get(j).force.x = -balls.get(i).force.x + balls.get(j).force.x;
                balls.get(i).force.y = balls.get(i).force.y + (float)(force * (balls.get(j).pos.y - balls.get(i).pos.y) / distance);
                balls.get(j).force.y = -balls.get(i).force.y + balls.get(j).force.y;
            }
        }

    }



}
