package managers;


import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;
import entities.*;



public class PlayStateController {
    public static Elephant_Card elephant1 = new Elephant_Card(1,3,"img/ele1.png","img/ele3.png",Cords.elephant_1_x, Cords.elephant_1_y,0);
    public static Elephant_Card elephant2 = new Elephant_Card(2,4,"img/ele2.png","img/ele4.png",Cords.elephant_2_x, Cords.elephant_2_y,1);
    public static Elephant_Card[] Elephant_cards = {elephant1, elephant2};

    public static Texture cordMap = new Texture("img/cordMap.png");
    public static Texture card = new Texture("img/card.png");
    public static Texture avatar_1 = new Texture("img/P1_avatar.png");
    public static Texture avatar_2 = new Texture("img/P2_avatar.png");
    public static Texture avatar_3 = new Texture("img/P3_avatar.png");
    public static Texture avatar_4 = new Texture("img/P4_avatar.png");

    public static Texture special = new Texture("img/special_1.png");

    public static Texture leaf = new Texture("img/leaf_top_right_yellow.png");

    public static Texture frame = new Texture("img/frame_v.png");

    public static Texture special_frame = new Texture("img/frame_c.png");
    public static Texture elephant_frame = new Texture("img/frame_v.png");

    public static int phase = 0;

    public static int selected_special = 99;

    public static int numOfPlayers = 4;
    public static Player currentPlayer;
    public static int currentPlayerIndex;
    public static Player[] players = new Player[4];

    public static boolean selected = false;

    public static Monkey blue;
    public static Monkey orange;
    public static Monkey pink;
    public static Monkey green;

    private static final Texture holdOn = new Texture("img/special_1.png");
    private static final Texture breakTime = new Texture("img/special_2.png");
    private static final Texture monkeySwap = new Texture("img/special_3.png");
    private static final Texture turboElephant = new Texture("img/special_4.png");
    private static final Texture freeMove = new Texture("img/special_5.png");
    private static final Texture exchange = new Texture("img/special_6.png");

    public static boolean[] useable_special = {true,true,true,true,true,true};

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
            players[i] = new Player(playerNames[i], i, Game.batch);
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
            elephant2.handleClick();
            elephant1.handleClick();
            Confirm_button.confirm_click();

        }


    }

    public static void update(){

        for (int i = 0; i<4; i++){
            players[i].update();
        }


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
        Game.batch.draw(blue.img, Cords.cord[blue.location][0],Cords.cord[blue.location][1]);
        Game.batch.draw(orange.img, Cords.cord[orange.location][0],Cords.cord[orange.location][1]);
        Game.batch.draw(pink.img, Cords.cord[pink.location][0],Cords.cord[pink.location][1]);
        Game.batch.draw(green.img, Cords.cord[green.location][0],Cords.cord[green.location][1]);
        Game.batch.draw(Elephant.img, Cords.cord[Elephant.location][0], Cords.cord[Elephant.location][1]);
        //---- Monkeys and elephant-----------------


        //-------- Player and cards-------------------
        Game.batch.draw(card,Cords.bottom_card_1_x,Cords.bottom_card_1_y);
        for (int i = 0; i < numOfPlayers; i++) {
            players[i].draw();
        }
        //-------- Player and cards-------------------


        //------------ Special ----------------------
        if(useable_special[0]){
            Game.batch.draw(holdOn, Cords.special[0][0], Cords.special[0][1]);
        }

        if(useable_special[1]){
            Game.batch.draw(breakTime, Cords.special[1][0], Cords.special[1][1]);
        }

        if(useable_special[5]){
            Game.batch.draw(exchange, Cords.special[5][0], Cords.special[5][1]);
        }

        if(useable_special[3]){
            Game.batch.draw(turboElephant, Cords.special[3][0], Cords.special[3][1]);
        }

        if(useable_special[2]){
            Game.batch.draw(monkeySwap, Cords.special[2][0], Cords.special[2][1]);
        }

        if(useable_special[4]){
            Game.batch.draw(freeMove, Cords.special[4][0], Cords.special[4][1]);
        }

        if(selected_special != 99){
            Game.batch.draw(special_frame, Cords.special[selected_special][0] - (float)7, Cords.special[selected_special][1] - (float)7);
        }
        //------------ Special ----------------------


        //-------- Confirm Button ----------------------
        Game.batch.draw(Confirm_button.btn, Confirm_button.x, Confirm_button.y);
        //-------- Confirm Button ----------------------

        //-------- Elephant Card ----------------------
        elephant1.draw();
        elephant2.draw();
        if(Elephant_Card.selected != 99){
            Game.batch.draw(elephant_frame, Elephant_cards[Elephant_Card.selected].x - 9, Elephant_cards[Elephant_Card.selected].y - 9);
        }
        //-------- Elephant Card ----------------------

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
