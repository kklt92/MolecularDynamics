package cn.mingweihao.MolecularDynamics;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by kklt92 on 13/08/2014.
 */
public class MolecularDynamics extends Game {
    SpriteBatch batch;


    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new MainScreen(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
    }

}
