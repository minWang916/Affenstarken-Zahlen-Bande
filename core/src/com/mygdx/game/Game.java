package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.audio.Music;
import gamestates.GameState;
import managers.GameStateManager;

public class Game implements ApplicationListener {
	SpriteBatch batch;
	Texture img;


	public Music bgm;
	public static int WIDTH;
	public static int HEIGHT;
	public static OrthographicCamera cam;
	private GameStateManager gsm;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("img/jayce.jpg");

		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		gsm = new GameStateManager();

		cam = new OrthographicCamera((float)WIDTH, (float)HEIGHT);
		cam.translate((float)(WIDTH / 2), (float)(HEIGHT / 2));
		cam.update();

		bgm = Gdx.audio.newMusic(Gdx.files.internal("sound/bgm/safe.mp3"));
		bgm.setLooping(true);
		bgm.play();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		//batch.draw(img, 0, 0);
		batch.end();

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();

		/*
		if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
			float mouseX = Gdx.input.getX();
			float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY(); // Invert Y-axis

			// Handle the click event or perform any other actions
			System.out.println("Mouse Clicked at: (" + mouseX + ", " + mouseY + ")");

		}
		*/

	}


	public void resize(int width, int height) {
	}


	public void pause() {
	}

	public void resume() {
	}


	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
