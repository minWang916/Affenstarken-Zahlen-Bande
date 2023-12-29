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

    public static int i = 0;

    private static int numOfPlayers = 4;
    private static Player currentPlayer;
    private static int currentPlayerIndex;
    private static Player[] players = new Player[4];

    public static void init(){
        String[] playerNames = {"Toby", "Thomas", "Kevin", "Michael"};
        for(int i = 0; i< 4; i++){
            players[i] = new Player(playerNames[i]);
        }
        currentPlayerIndex = 0;
        currentPlayer = players[0];
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
        Game.batch.draw(monkey, Cords.cord[i][0],Cords.cord[i][1]);
        //---- Monkeys and elephant-----------------


        //-------- Player and cards-------------------
        Game.batch.draw(card,Cords.top_card_4_x,Cords.top_card_4_y);
        Game.batch.draw(avatar, Cords.top_avatar_x, Cords.top_avatar_y);
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
            i = i + 1;
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
