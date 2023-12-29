package entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import entities.Cords;

public class Player {
    private BitmapFont font;
    private static SpriteBatch batch;

    private String name;
    private int id;

    private String state = "";

    private boolean playing = false;

    public Player (String name, int id, SpriteBatch batch) {
        this.name = name;
        this.id = id;
        this.batch = batch;
        System.out.println("Player created with the name " + this.name);

        font = new BitmapFont();
    }

    public void init(){

    }

    public void update(){

    }

    public void draw(){
        if (playing == true) {
            font.setColor(Color.GREEN);
        }
        font.draw(batch, "Hello World!", Cords.all_player_cord[id-1][0][0], Cords.all_player_cord[id-1][0][1]);
        font.setColor(Color.WHITE);
    }

    public void startTurn(){
        System.out.println("This is my turn and I am " + name);
        playing = true;
    }

    public void endTurn(){
        System.out.println("I am ending my turn and I am " + name);
        playing = false;
    }
}
