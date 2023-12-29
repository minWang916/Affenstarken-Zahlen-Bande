package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import entities.Cords;

public class Player {
    private BitmapFont font;
    private static SpriteBatch batch;

    private String name;
    private int id;

    private String state = "";

    private boolean playing = false;

    private Texture avatar;

    public Player (String name, int id, SpriteBatch batch) {
        this.name = name;
        this.id = id;
        this.batch = batch;
        System.out.println("Player created with the name " + this.name);

        init();
    }

    public void init(){
        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
                Gdx.files.internal("font/VCR_OSD_MONO_1.001.ttf")
        );
        FreeTypeFontGenerator.FreeTypeFontParameter param_titleFont = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param_titleFont.size = 20;
        font = gen.generateFont(param_titleFont);
        avatar = new Texture("img/P1_avatar.png");
    }

    public void update(){

    }

    public void draw(){
        if (playing == true) {
            font.setColor(Color.GREEN);
        }
        font.draw(batch, name, Cords.all_player_cord[id-1][0][0] - 10, Cords.all_player_cord[id-1][0][1] + 80);
        font.setColor(Color.WHITE);

        batch.draw(avatar, Cords.all_player_cord[id-1][0][0], Cords.all_player_cord[id-1][0][1]);
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
