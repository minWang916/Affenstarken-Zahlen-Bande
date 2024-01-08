package entities;

import static managers.PlayStateController.*;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Game;
import java.util.ArrayList;
import entities.Cords;
import managers.PlayStateController;

public class Card {

    private int number;

    private String color;

    private SpriteBatch batch;

    private int player_id;
    private int card_id;

    private float[] topCorner = new float[2];
    private float[] bottomCorner = new float[2];

    public boolean selected = false;

    private Texture frame;

    private Texture colorTexture;
    private Sprite colorSprite;
    private Texture numberTexture;
    private Sprite numberSprite;
    private static Texture monkeyTexture = new Texture("img/card_asset/monkey.png");
    private Sprite monkeySprite;
    private float rotation = 0;
    private float[] offset = new float[2];

    public Card(int number, String color, SpriteBatch batch, int player_id, int card_id){
        this.number = number;
        this.color = color;
        this.batch = batch;
        this.player_id = player_id;
        this.card_id = card_id;
        PlayStateController.allMonkeyCards.add(this);
        monkeySprite = new Sprite(monkeyTexture);
        setCard();
    }

    public void setCard(){
        bottomCorner[0] = Cords.all_player_cord[player_id][card_id+1][0];
        bottomCorner[1] = Cords.all_player_cord[player_id][card_id+1][1];

        // Color setting
        colorTexture = Cords.card_asset_color[getColorIndex()];
        colorSprite = new Sprite(colorTexture);

        // Number setting
        if (!(number < 5 || number > 15)) {
            numberTexture = Cords.card_asset_number[number - 5];
        } else {
            numberTexture = Cords.card_asset_transparent;
        }
        numberSprite = new Sprite(numberTexture);

        // Rotation setting
        if ((player_id == 1) || (player_id == 3)) {
            topCorner[0] = bottomCorner[0] + 100;
            topCorner[1] = bottomCorner[1] + 68;
            frame = new Texture("img/frame_h.png");
            if (player_id == 1) rotation = 90;
            else rotation = -90;
            offset[0] = 17;
            offset[1] = -15;
        } else {
            topCorner[0] = bottomCorner[0] + 68;
            topCorner[1] = bottomCorner[1] + 100;
            frame = new Texture("img/frame_v.png");
            rotation = 0;
            offset[0] = 0;
            offset[1] = 0;
        }
        colorSprite.setRotation(rotation);
        numberSprite.setRotation(rotation);
        monkeySprite.setRotation(rotation);

        // Sprite setting
        colorSprite.setPosition(bottomCorner[0] + offset[0], bottomCorner[1] + offset[1]);
        numberSprite.setPosition(bottomCorner[0] + offset[0], bottomCorner[1] + offset[1]);
        monkeySprite.setPosition(bottomCorner[0] + offset[0], bottomCorner[1] + offset[1]);
    }

    public void update(){
        handleInput();
    }

    public void empty(){
        number = 0;
        color = "transparent";
        selected = false;
        setCard();
    }

    public void pickFromDeck(){
        number = (int)(Math.random()*11 + 5);
        color = Cords.colors[(int)(Math.random()*4)];
        setCard();
    }

    public void draw(){
        colorSprite.draw(batch);
        monkeySprite.draw(batch);
        numberSprite.draw(batch);

        if (selected) {
            batch.draw(frame, bottomCorner[0]-9, bottomCorner[1]-9);
        }
    }

    public void handleInput(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(bottomCorner[0] < X && X < topCorner[0] && bottomCorner[1] < Y && Y < topCorner[1]
                    && phase == PHASE_MONKEY && currentPlayerIndex == this.player_id){
                toggleSelect();
            }
        }
    }

    public void toggleSelect(){
        if(selected == false){
            Cords.selectSound.play(0.1f);
            selected = true;
            selectedMonkeyCards.add(this);
        }else{
            Cords.unselectSound.play(0.1f);
            selected = false;
            selectedMonkeyCards.remove(this);
        }
    }

    public int getColorIndex(){
        for (int i=0; i<4; i++){
            if (color == Cords.colors[i])
                return i;
        }
        return 4;
    }

    public int getNumber(){
        return number;
    }

}

