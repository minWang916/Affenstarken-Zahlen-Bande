package managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;
import entities.*;
import managers.GameInputHandler;

import org.w3c.dom.Text;

import entities.*;
public class PlayStateController {

    public static Texture cordMap = new Texture("img/cordMap.png");
    public static Texture card = new Texture("img/card.png");
    public static Texture avatar_1 = new Texture("img/P1_avatar.png");
    public static Texture avatar_2 = new Texture("img/P2_avatar.png");
    public static Texture avatar_3 = new Texture("img/P3_avatar.png");
    public static Texture avatar_4 = new Texture("img/P4_avatar.png");

    public static Texture special = new Texture("img/special_1.png");

    public static Texture leaf = new Texture("img/leaf_top_right_yellow.png");

    public static Texture frame = new Texture("img/frame_v.png");

    public static int phase = 0;

    public static int numOfPlayers = 4;
    public static Player currentPlayer;
    public static int currentPlayerIndex;
    public static Player[] players = new Player[4];

    public static boolean selected = false;

    public static Monkey blue;
    public static Monkey orange;
    public static Monkey pink;
    public static Monkey green;

    private static Texture holdOn = new Texture("img/special_1.png");
    private static Texture breakTime = new Texture("img/special_2.png");
    private static Texture monkeySwap = new Texture("img/special_3.png");
    private static Texture turboElephant = new Texture("img/special_4.png");
    private static Texture freeMove = new Texture("img/special_5.png");
    private static Texture exchange = new Texture("img/special_6.png");

    public static boolean useable_holdOn = true;
    public static boolean useable_breakTime = true;
    public static boolean useable_monkeySwap = true;
    public static boolean useable_turboElephant = true;
    public static boolean useable_freeMove = true;
    public static boolean useable_exchange = true;

    public static final int PHASE_SPECIAL = 0;
    public static final int PHASE_MONKEY = 1;
    public static final int PHASE_ELEPHANT = 2;
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

    public static void handleInput(){



        
        if(phase == PHASE_SPECIAL){
            GameInputHandler.special();
            Confirm_button.confirm_click();
        }else if(phase == PHASE_MONKEY){
            Confirm_button.confirm_click();
        }else if(phase == PHASE_ELEPHANT){
            Confirm_button.confirm_click();
        }



        GameInputHandler.bottom_card_1();



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
        for (int i = 0; i < numOfPlayers; i++) {
            players[i].draw();
        }
        Game.batch.draw(card,Cords.bottom_card_1_x,Cords.bottom_card_1_y);
        if(selected){
            Game.batch.draw(frame, Cords.bottom_card_1_x - 9, Cords.bottom_card_1_y - 9);
        }
        if(selected){
            Game.batch.draw(frame, Cords.bottom_card_1_x - 9, Cords.bottom_card_1_y - 9);
        }
        //-------- Player and cards-------------------


        //------------ Special ----------------------
        if(useable_holdOn){
            Game.batch.draw(holdOn, Cords.special[0][0], Cords.special[0][1]);
        }

        if(useable_breakTime){
            Game.batch.draw(breakTime, Cords.special[1][0], Cords.special[1][1]);
        }

        if(useable_exchange){
            Game.batch.draw(exchange, Cords.special[5][0], Cords.special[5][1]);
        }

        if(useable_turboElephant){
            Game.batch.draw(turboElephant, Cords.special[3][0], Cords.special[3][1]);
        }

        if(useable_monkeySwap){
            Game.batch.draw(monkeySwap, Cords.special[2][0], Cords.special[2][1]);
        }

        if(useable_freeMove){
            Game.batch.draw(freeMove, Cords.special[4][0], Cords.special[4][1]);
        }
        //------------ Special ----------------------


        //-------- Confirm Button ----------------------
        Game.batch.draw(Confirm_button.btn, Confirm_button.x, Confirm_button.y);
        //-------- Confirm Button ----------------------
    }

    public static void dispose(){

        cordMap.dispose();

        avatar_1.dispose();
        avatar_2.dispose();
        avatar_3.dispose();
        avatar_4.dispose();

        pink.dispose();
        blue.dispose();
        green.dispose();
        orange.dispose();

        holdOn.dispose();
        breakTime.dispose();
        monkeySwap.dispose();
        turboElephant.dispose();
        freeMove.dispose();
        exchange.dispose();
    }


}
