package cn.mingweihao.MolecularDynamics;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

public class MainScreen implements Screen {
    MolecularDynamics game;

	Map map;

    Texture ballImage;
    OrthographicCamera camera;



    public MainScreen(MolecularDynamics game) {
        this.game = game;

        ballImage = new Texture(Gdx.files.internal("XeMolecular.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

    }
	

    @Override
    public void show() {
        map = new Map();
    }

	@Override
	public void render (float delta) {


      //  delta = Math.min(0.06f, Gdx.graphics.getDeltaTime());
        delta = 0.06f;
        map.update(delta);

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        for(int i = 0; i < map.balls.size; i++) {
            game.batch.draw(ballImage, map.balls.get(i).pos.x - 10, map.balls.get(i).pos.y - 10, 20f, 20f);
        }
        game.batch.end();


	}

    public void dispose() {

    }

    public void resume() {

    }

    public void pause() {

    }


    public void resize(int width, int height) {

    }


    public void hide() {

    }


}
