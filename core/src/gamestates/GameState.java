package gamestates;

import managers.GameStateManager;

public abstract class GameState {
    protected GameStateManager gsm;

    protected GameState(GameStateManager gsm){
           this.gsm = gsm;

    }

    public abstract void init();

    public abstract void update(float var1);

    public abstract void draw();

    public abstract void handleInput();

    public abstract void dispose();

}
