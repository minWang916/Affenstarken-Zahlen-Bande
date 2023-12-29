package managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;
import entities.*;

import org.w3c.dom.Text;

import entities.*;
public class PlayStateController {

    public static Texture cordMap = new Texture("img/cordMap.png");
    public static Texture card = new Texture("img/card.png");
    public static Texture avatar = new Texture("img/P2_avatar.png");

    public static Texture special = new Texture("img/special_1.png");

    public static Texture leaf = new Texture("img/leaf_top_right_yellow.png");
    public static Texture monkey = new Texture("img/monkey_blue.png");

    public static Texture frame = new Texture("img/frame.png");

    public static int i = 0;

    private static int numOfPlayers = 4;
    private static Player currentPlayer;
    private static int currentPlayerIndex;
    private static Player[] players = new Player[4];

    private static boolean selected = false;

    private static Monkey blue;
    private static Monkey orange;
    private static Monkey pink;
    private static Monkey green;

    public static void init(){

        //-------------------- Entities------------------------------------------
        blue = new Monkey("blue");
        orange = new Monkey("orange");
        green = new Monkey("green");
        pink = new Monkey("pink");
        //-------------------- Entities------------------------------------------


        //------------------- Turn based-----------------------------------------
        String[] playerNames = {"Toby", "Thomas", "Kevin", "Michael"};
        for(int i = 0; i< 4; i++){
            players[i] = new Player(playerNames[i], i+1, Game.batch);
        }
        currentPlayerIndex = 0;
        currentPlayer = players[0];
        currentPlayer.startTurn();
        //------------------- Turn based-----------------------------------------
    }

    public static void update(){

        handleInput();


        //---------- Leaves -----------------------

        //---------- Leaves ------------------------


        //---- Monkeys and elephant-----------------

        //---- Monkeys and elephant-----------------


        //-------- Player and cards-------------------

        //-------- Player and cards-------------------


        //------------ Special ----------------------

        //------------ Special ----------------------
    }

    public static void draw(){
        //---------- Players -----------------------

        for (int i = 0; i < numOfPlayers; i++) {
            players[i].draw();
        }

        //---------- Players -----------------------


        //---------- Leaves ------------------------
        Game.batch.draw(leaf,0,0);
        //---------- Leaves ------------------------


        //---------- Cord map ----------------------
        Game.batch.draw(cordMap,Cords.cordMap_x,Cords.cordMap_y);
        //---------- Cord map ----------------------


        //---- Monkeys and elephant-----------------
        Game.batch.draw(blue.img, Cords.cord[4][0],Cords.cord[4][1]);
        Game.batch.draw(orange.img, Cords.cord[1][0],Cords.cord[1][1]);
        Game.batch.draw(pink.img, Cords.cord[2][0],Cords.cord[2][1]);
        Game.batch.draw(green.img, Cords.cord[17][0],Cords.cord[17][1]);
        Game.batch.draw(Elephant.img, Cords.cord[0][0], Cords.cord[0][1]);
        //---- Monkeys and elephant-----------------


        //-------- Player and cards-------------------
        Game.batch.draw(card,Cords.bottom_card_1_x,Cords.bottom_card_1_y);
        Game.batch.draw(avatar, Cords.top_avatar_x, Cords.top_avatar_y);
        if(selected){
            Game.batch.draw(frame, Cords.bottom_card_1_x - 9, Cords.bottom_card_1_y - 9);
        }
        //-------- Player and cards-------------------


        //------------ Special ----------------------
        Game.batch.draw(special, Cords.special_4_x, Cords.special_4_y);
        //------------ Special ----------------------
    }

    public static void dispose(){

        cordMap.dispose();
    }

    public static void handleInput(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
            //i = i + 1;
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(360 < X && X < 427 && 37 < Y && Y < 136){
                if(selected == false){
                    selected = true;
                }else{
                    selected = false;
                }
            }
        }





        if (Gdx.input.isKeyJustPressed(Input.Keys.W)){
            currentPlayer.endTurn();
            currentPlayerIndex += 1;
            currentPlayerIndex = currentPlayerIndex % 4;
            currentPlayer = players[currentPlayerIndex];
            currentPlayer.startTurn();
        }
    }
}
