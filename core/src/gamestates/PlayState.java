package gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Game;
import managers.PlayStateController;
import entities.*;

import managers.GameStateManager;

public class PlayState extends GameState{
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;



    public PlayState (GameStateManager gsm){
        super(gsm);
        init();
    }

    public void init() {

        PlayStateController.init();

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
        Game.batch.end();

    }

    public void handleInput(){

        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY(); // Invert Y-axis

            // Handle the click event or perform any other actions
            System.out.println("Mouse Clicked at: (" + X + ", " + Y + ")");



        }

    }

    public void dispose(){

        PlayStateController.dispose();
    }

}
