package entities;

import static managers.PlayStateController.selected;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Game;

import entities.Cords;

public class Card {
    private int number;

    private String color;

    private SpriteBatch batch;

    private int player_id;
    private int card_id;

    private float[] topCorner = new float[2];
    private float[] bottomCorner = new float[2];

    private boolean selected = false;

    private Texture frame;

    public Texture drawTexture;

    private ShapeRenderer shapeRenderer;

    public Card(int number, String color, SpriteBatch batch, int player_id, int card_id){
        this.number = number;
        this.color = color;
        this.batch = batch;
        this.player_id = player_id;
        this.card_id = card_id;

        System.out.println("Card created with player id: " + this.player_id + " and card id: " + card_id);

        init();
    }

    public void init(){
        shapeRenderer = new ShapeRenderer();

        bottomCorner[0] = Cords.all_player_cord[player_id][card_id+1][0];
        bottomCorner[1] = Cords.all_player_cord[player_id][card_id+1][1];

        if ((player_id == 1) || (player_id == 3)) {
            topCorner[0] = bottomCorner[0] + 100;
            topCorner[1] = bottomCorner[1] + 68;
            frame = new Texture("img/frame_h.png");
            drawTexture = new Texture("img/card_rotate.png");
            System.out.println("Player id: " + player_id);
        } else {
            topCorner[0] = bottomCorner[0] + 68;
            topCorner[1] = bottomCorner[1] + 100;
            frame = new Texture("img/frame_v.png");
            drawTexture = new Texture("img/ele1.png");
        }
    }

    public void update(){
        handleInput();
    }

    public void draw(){
        batch.draw(drawTexture, bottomCorner[0], bottomCorner[1]);
        if (selected) {
            Game.batch.draw(frame, bottomCorner[0]-9, bottomCorner[1]-9);
        }
    }

    public void handleInput(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(bottomCorner[0] < X && X < topCorner[0] && bottomCorner[1] < Y && Y < topCorner[1]){
                if(selected == false){
                    selected = true;
                }else{
                    selected = false;
                }
            }
        }
    }
}
