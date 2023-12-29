package entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

    public Card(int number, String color, SpriteBatch batch, int player_id, int card_id){
        this.number = number;
        this.color = color;
        this.batch = batch;
        this.player_id = player_id;
        this.card_id = card_id;

        init();
    }

    public void init(){
        bottomCorner[0] = Cords.all_player_cord[player_id][card_id][0];
        bottomCorner[1] = Cords.all_player_cord[player_id][card_id][1];

        if ((player_id == 1) || (player_id == 3)) {
            topCorner[0] = Cords.all_player_cord[player_id][card_id][0] + 100;
            topCorner[1] = Cords.all_player_cord[player_id][card_id][1] + 68;
        } else {
            topCorner[0] = Cords.all_player_cord[player_id][card_id][0] + 68;
            topCorner[1] = Cords.all_player_cord[player_id][card_id][1] + 100;
        }
    }

    public void update(){

    }

    public void draw(){
        
    }

    public void inputHandler(){

    }
}
