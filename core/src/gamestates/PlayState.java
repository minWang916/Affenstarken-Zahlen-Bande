package gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Game;

import java.awt.Menu;

import managers.PlayStateController;
import entities.*;
import gamestates.MenuState;
import managers.GameStateManager;

public class PlayState extends GameState{
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    public String[] usernames;
    private Texture iconSetting;


    public PlayState (GameStateManager gsm){
        super(gsm);
        init();
    }

    public void init() {

        iconSetting = new Texture("img/setting.png");
        usernames = MenuState.getNames();
        int[] avatars = MenuState.getAvatars();
        PlayStateController.init(usernames, avatars);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("real/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        Game.cam.position.set(Game.gamePort.getWorldWidth()/2, Game.gamePort.getWorldHeight()/2,0);

    }

    public void update(float var1){

        handleInput();
        PlayStateController.update();
        Game.cam.update();
        renderer.setView(Game.cam);



    }

    public void draw(){


        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Game.batch.begin();
        renderer.render();
        PlayStateController.draw();
        Game.batch.draw(iconSetting,930,740);
        Game.batch.end();

        if(Game.endResult != ""){
            gsm.setState(gsm.END);
        }

    }

    public void handleInput(){

        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY(); // Invert Y-axis
            if(930 < X && X < 930 + 50 && 740 < Y && Y < 740 + 50){
                gsm.setState(gsm.SETTING);
            }
        }

    }

    public void dispose(){

        PlayStateController.dispose();
    }

}
