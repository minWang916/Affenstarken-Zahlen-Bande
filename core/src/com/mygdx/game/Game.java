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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import entities.Elephant;
import entities.Elephant_Card;
import gamestates.EndState;
import gamestates.GameState;
import managers.GameSpecialHandler;
import managers.GameStateManager;
import managers.PlayStateController;

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

	public static float masterVolume = 10;


	@Override
	public void create () {


		batch = new SpriteBatch();
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		gsm = new GameStateManager();

		cam = new OrthographicCamera((float)WIDTH, (float)HEIGHT);

		gamePort = new StretchViewport(WIDTH, HEIGHT, cam);
		//gamePort = new ScreenViewport();
		//cam.translate((float)(WIDTH / 2), (float)(HEIGHT / 2));
		//cam.update();

		bgm = Gdx.audio.newMusic(Gdx.files.internal("sound/bgm/safe.mp3"));
		bgm.setLooping(true);
		bgm.setVolume(0.1F*bgmVolume);
		bgm.play();
	}

	@Override
	public void render () {
		bgm.setVolume(0.1F*bgmVolume*masterVolume/10);
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
		GameSpecialHandler.dispose();

		for(int i = 0; i < 4; i++){
			PlayStateController.monkeys[i].dispose();
		}

		PlayStateController.elephant1.dispose();
		PlayStateController.elephant2.dispose();
		Elephant.dispose();

		for(int i = 0; i < PlayStateController.allMonkeyCards.size(); i++){
			PlayStateController.allMonkeyCards.get(i).dispose();
		}

		for(int i = 0; i < PlayStateController.selectedMonkeyCards.size(); i++){
			PlayStateController.selectedMonkeyCards.get(i).dispose();
		}

		PlayStateController.cordMap.dispose();
		PlayStateController.frame.dispose();
		PlayStateController.special_frame.dispose();

		PlayStateController.holdOn.dispose();
		PlayStateController.breakTime.dispose();
		PlayStateController.monkeySwap.dispose();
		PlayStateController.turboElephant.dispose();
		PlayStateController.freeMove.dispose();
		PlayStateController.exchange.dispose();

		PlayStateController.iconPink.dispose();
		PlayStateController.iconGreen.dispose();
		PlayStateController.iconBlue.dispose();
		PlayStateController.iconOrange.dispose();

	}
}
