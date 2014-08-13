package cn.mingweihao.MolecularDynamics;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.awt.*;

/**
 * Created by kklt92 on 11/08/2014.
 */
public class Map {
    public Rectangle outbounds = new Rectangle();
    public Array<Ball> balls = new Array<Ball>();

    public Map() {
        load();
    }

    private void load() {
        for(int i = 0; i < 20; i++) {
            Ball ball = new Ball(this, (float)(Math.random() * 400), (float)(Math.random() * 200));
            balls.add(ball);
        }
    }

    public void update(float deltaTime) {
        for(int i = 0; i < balls.size; i++) {
            balls.get(i).update(deltaTime);

        }
    }
}
