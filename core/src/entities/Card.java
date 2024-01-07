package entities;

import static managers.PlayStateController.PHASE_MONKEY;
import static managers.PlayStateController.currentPlayerIndex;
import static managers.PlayStateController.selected;
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

    public static int totalSelected = 0;

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

    private ShapeRenderer shapeRenderer;
    private float rotation = 0;
    private float[] offset = new float[2];

    public Card(int number, String color, SpriteBatch batch, int player_id, int card_id){
        this.number = number;
        this.color = color;
        this.batch = batch;
        this.player_id = player_id;
        this.card_id = card_id;
        System.out.println("Card created with player id: " + this.player_id + " and card id: " + card_id);

        PlayStateController.Cards.add(this);
        init();
    }

    public void init(){
        shapeRenderer = new ShapeRenderer();

        bottomCorner[0] = Cords.all_player_cord[player_id][card_id+1][0];
        bottomCorner[1] = Cords.all_player_cord[player_id][card_id+1][1];

        // Color setting
        if (color == "orange") {
            colorTexture = Cords.card_asset_orange;
        } else if (color == "green") {
            colorTexture = Cords.card_asset_green;
        } else if (color == "blue") {
            colorTexture = Cords.card_asset_blue;
        } else {
            colorTexture = Cords.card_asset_pink;
        }
        colorSprite = new Sprite(colorTexture);

        // Number setting
        numberTexture = Cords.card_asset_number[number-5];
        numberSprite = new Sprite(numberTexture);

        // Rotation setting
        if ((player_id == 1) || (player_id == 3)) {
            topCorner[0] = bottomCorner[0] + 100;
            topCorner[1] = bottomCorner[1] + 68;
            frame = new Texture("img/frame_h.png");
            rotation = 90;
            colorSprite.setRotation(rotation);
            numberSprite.setRotation(rotation);
            offset[0] = 17;
            offset[1] = -15;
        } else {
            topCorner[0] = bottomCorner[0] + 68;
            topCorner[1] = bottomCorner[1] + 100;
            frame = new Texture("img/frame_v.png");
            rotation = 0;
            colorSprite.setRotation(rotation);
            numberSprite.setRotation(rotation);
            offset[0] = 0;
            offset[1] = 0;
        }

        // Sprite setting
        colorSprite.setPosition(bottomCorner[0] + offset[0], bottomCorner[1] + offset[1]);
        numberSprite.setPosition(bottomCorner[0] + offset[0], bottomCorner[1] + offset[1]);
    }

    public void update(){
        handleInput();
    }

    public void draw(){
        colorSprite.draw(batch);
        numberSprite.draw(batch);

        if (selected) {
            batch.draw(frame, bottomCorner[0]-9, bottomCorner[1]-9);
        }
    }

    public void handleInput(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(bottomCorner[0] < X && X < topCorner[0] && bottomCorner[1] < Y && Y < topCorner[1] && PlayStateController.phase == PHASE_MONKEY && currentPlayerIndex == this.player_id){
                if(selected == false){
                    selected = true;
                    totalSelected = totalSelected + 1;
                }else{
                    selected = false;
                    totalSelected = totalSelected - 1;
                }
            }
        }
    }
}

