package cn.mingweihao.MolecularDynamics;

import android.util.Log;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by kklt92 on 13/08/2014.
 */
public class MolecularDynamics extends Game {
    SpriteBatch batch;

    private static String TAG = "MyActivity";


    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new MainScreen(this));

        Log.i(TAG, "Screen Width is " + Gdx.graphics.getWidth());
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
    }

}
