package cn.mingweihao.MolecularDynamics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;




/**
 * Created by kklt92 on 11/08/2014.
 */
public class Map {

    public Rectangle outbounds = new Rectangle();
    public Array<Ball> balls = new Array<Ball>();
    public Array<Vector2> ballPos = new Array<Vector2>();
    public Array<Vector2> ballVel = new Array<Vector2>();

    public Map() {
        load();
    }

    private void load() {
        for(int i = 0; i < 100; i++) {
            Ball ball = new Ball(this, (float)(Math.random() * 800), (float)(Math.random() * 480));
            balls.add(ball);
        }

    }

    public void update(float deltaTime) {
        for(int i = 0; i < balls.size; i++) {
            balls.get(i).update(deltaTime);

        }
    }




}
