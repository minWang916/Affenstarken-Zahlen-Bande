package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import gamestates.GameState;
import managers.GameStateManager;

public class Game implements ApplicationListener {
	public static SpriteBatch batch;

	public static String endResult = "";

	public static float sfxVolume = 1.0F;
	public static float bgmVolume = 1.0F;

	public static String language = "en";

	public static Music bgm;
	public static int WIDTH;
	public static int HEIGHT;
	public static OrthographicCamera cam;
	public GameStateManager gsm;
	public static Viewport gamePort;

	@Override
	public void create () {


		batch = new SpriteBatch();
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		gsm = new GameStateManager();

		cam = new OrthographicCamera((float)WIDTH, (float)HEIGHT);
		gamePort = new StretchViewport(WIDTH, HEIGHT, cam);
		//cam.translate((float)(WIDTH / 2), (float)(HEIGHT / 2));
		//cam.update();

		bgm = Gdx.audio.newMusic(Gdx.files.internal("sound/bgm/safe.mp3"));
		bgm.setLooping(true);
		bgm.setVolume(0.1F*bgmVolume);
		bgm.play();
	}

	@Override
	public void render () {
		bgm.setVolume(0.1F*bgmVolume);
		ScreenUtils.clear(1, 0, 0, 1);

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();
	}


	public void resize(int width, int height) {
	}


	public void pause() {
	}

	public void resume() {
	}


	@Override
	public void dispose () {

		//img.dispose();
	}
}
