package gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import managers.GameStateManager;

public class PlayState extends GameState{
    public PlayState (GameStateManager gsm){
        super(gsm);
        init();
    }

    public void init() {}

    public void update(float var1){

        System.out.println("PLAY STATE UPDATING");
        handleInput();
    }

    public void draw(){
        System.out.println("PLAY STATE DRAWING");

    }

    public void handleInput(){

        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){

            gsm.setState(gsm.MENU);

        }

    }

    public void dispose(){}

}
