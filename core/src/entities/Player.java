package entities;

import static managers.PlayStateController.PHASE_ELEPHANT;
import static managers.PlayStateController.PHASE_MONKEY;
import static managers.PlayStateController.PHASE_SPECIAL;
import static managers.PlayStateController.phase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import managers.PlayStateController.*;

import entities.Cords;
import entities.Card;

public class Player {
    private BitmapFont font;
    private static SpriteBatch batch;

    private String name;
    private int id;

    private String state = "";

    private boolean playing = false;

    private Texture avatar;

    private Card[] cards = new Card[4];

    public Player (String name, int id, SpriteBatch batch) {
        this.name = name;
        this.id = id;
        this.batch = batch;
        System.out.println("Player created with the name " + this.name + " and id: " + this.id);

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

        //Deal cards
        for (int i = 0; i<4; i++) {
            cards[i] = new Card(1, "red", batch, id, i);
        }
    }

    public void update(){
        for (int i = 0; i<4; i++){
            cards[i].update();
        }
    }

    public void draw(){
        // Draw name of the player corresponding to the phase
        if (playing == true) {
            if(phase == PHASE_SPECIAL){
                font.setColor(Color.GREEN);
            }
            if(phase == PHASE_MONKEY){
                font.setColor(Color.YELLOW);
            }
            if(phase == PHASE_ELEPHANT){
                font.setColor(Color.ORANGE);
            }
        }
        font.draw(batch, name, Cords.all_player_cord[id][0][0] - 10, Cords.all_player_cord[id][0][1] + 80);
        font.setColor(Color.WHITE);

        // Draw avatar of the player
        batch.draw(avatar, Cords.all_player_cord[id][0][0], Cords.all_player_cord[id][0][1]);

        // Draw cards of the player
        for (int i = 0; i<4; i++) {
            cards[i].draw();
        }
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

