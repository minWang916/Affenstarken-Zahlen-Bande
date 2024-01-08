package managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;
import entities.*;
import java.util.ArrayList;
import com.badlogic.gdx.Input;


public class PlayStateController {
    public static ArrayList<Card> allMonkeyCards = new ArrayList<>();
    public static ArrayList<Card> selectedMonkeyCards = new ArrayList<>();
    public static Elephant_Card elephant1 = new Elephant_Card(1,3,"img/ele1.png","img/ele3.png",Cords.elephant_1_x, Cords.elephant_1_y,0);
    public static Elephant_Card elephant2 = new Elephant_Card(2,4,"img/ele2.png","img/ele4.png",Cords.elephant_2_x, Cords.elephant_2_y,1);
    public static Elephant_Card[] Elephant_cards = {elephant1, elephant2};

    public static Texture cordMap = new Texture("img/cordMap.png");

    public static Texture frame = new Texture("img/frame_v.png");
    public static Texture special_frame = new Texture("img/frame_c.png");
    public static int phase = 0;
    public static int selected_special = 99;
    public static int numOfPlayers = 4;
    public static Player currentPlayer;
    public static int currentPlayerIndex;
    public static Player[] players = new Player[4];

    public static boolean selected = false;
    public static int selected_plus_or_minus = 99;

    public static Monkey blue;
    public static Monkey orange;
    public static Monkey pink;
    public static Monkey green;
    public static Monkey[] monkeys = new Monkey[4];

    public static Elephant elephant;

    private static final Texture holdOn = new Texture("img/special_1.png");
    private static final Texture breakTime = new Texture("img/special_2.png");
    private static final Texture monkeySwap = new Texture("img/special_3.png");
    private static final Texture turboElephant = new Texture("img/special_4.png");
    private static final Texture freeMove = new Texture("img/special_5.png");
    private static final Texture exchange = new Texture("img/special_6.png");
    public static int[] useable_special = {0,0,0,0,0,0};
    public static final int PHASE_SPECIAL = 0;
    public static final int PHASE_MONKEY = 1;
    public static final int PHASE_ELEPHANT = 2;
    public static double x_weight, y_weight = 0;
    public static double maxWeight = 200;
    public static double currentWeight = 0;

    public static Texture iconBlue = new Texture("img/monkey_blue.png");
    public static Texture iconOrange = new Texture("img/monkey_orange.png");
    public static Texture iconGreen = new Texture("img/monkey_green.png");
    public static Texture iconPink = new Texture("img/monkey_pink.png");
    public static int selectedIcon = 0;
    public static int selectedCord = 0;
    public static Texture cord;
    public static int countTurn = 0;
    public static PlayerAssistant assistant;

    public static void init(){
        //-------------------- Entities------------------------------------------
        blue = new Monkey("blue");
        orange = new Monkey("orange");
        green = new Monkey("green");
        pink = new Monkey("pink");
        monkeys = new Monkey[]{orange, green, blue, pink};
        elephant = new Elephant();
        assistant = new PlayerAssistant();
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
            GameSpecialHandler.special();
            Confirm_button.handleInput();
        }else if(phase == PHASE_MONKEY){
            Plus_Button.handleClick();
            Minus_Button.handleClick();
            Confirm_button.handleInput();
        }else if(phase == PHASE_ELEPHANT){
            elephant2.handleClick();
            elephant1.handleClick();
            Confirm_button.handleInput();
        }

    }

    public static void update(){

        handleInput();

        //---------- Leaves -----------------------

        //---------- Leaves ------------------------


        //---- Monkeys and elephant-----------------

        //---- Monkeys and elephant-----------------


        //--- Player (and cards - inside players)----

        for (int i = 0; i<4; i++){
            players[i].update();
        }

        //--- Player (and cards - inside players)----


        //------------ Special ----------------------

        //------------ Special ----------------------
    }

    public static void draw(){
        //---------Player Assistant-----------------
        assistant.draw();
        //---------Player Assistant-----------------

        //---------- Players -----------------------
        for (int i = 0; i < numOfPlayers; i++) { players[i].draw(); }
        //---------- Players -----------------------

        //---------- Leaves ------------------------
        for (int i=0; i<2; i++){
            for (int j=0; j<2; j++) {
                Game.batch.draw(Cords.leaf_asset[i][j][0], 0, 0);
            }
        }
        drawIndicatorLeaf();
        //---------- Leaves ------------------------


        //---------- Cord map ----------------------
        Game.batch.draw(cordMap,Cords.cordMap_x,Cords.cordMap_y);
        //---------- Cord map ----------------------


        //---- Monkeys and elephant-----------------
        for (int i=0; i<4; i++) { monkeys[i].draw(); }
        Elephant.draw();
        //---- Monkeys and elephant-----------------


        //-------- Player and cards-------------------
        for (int i = 0; i < numOfPlayers; i++) { players[i].draw(); }
        //-------- Player and cards-------------------


        //------------ Special ----------------------
        float X = Gdx.input.getX();
        float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
        if(useable_special[0] == 0){
            if(202 < X && X < 263 && 529 < Y && Y < 583){
                Game.batch.draw(GameSpecialHandler.hint0,GameSpecialHandler.x,GameSpecialHandler.y);
            }
            Game.batch.draw(holdOn, Cords.special[0][0], Cords.special[0][1]);
        }

        if(useable_special[1] == 0){
            if(202 < X && X < 263 && 367 < Y && Y < 426){
                Game.batch.draw(GameSpecialHandler.hint1,GameSpecialHandler.x,GameSpecialHandler.y);
            }
            Game.batch.draw(breakTime, Cords.special[1][0], Cords.special[1][1]);
        }

        if(useable_special[5] == 0){
            if(739 < X && X < 797 && 209 < Y && Y < 267){
                Game.batch.draw(GameSpecialHandler.hint5,GameSpecialHandler.x,GameSpecialHandler.y);
            }
            Game.batch.draw(exchange, Cords.special[5][0], Cords.special[5][1]);
        }

        if(useable_special[3] == 0){
            if(739 < X && X < 797 && 529 < Y && Y < 583){
                Game.batch.draw(GameSpecialHandler.hint3,GameSpecialHandler.x,GameSpecialHandler.y);
            }
            Game.batch.draw(turboElephant, Cords.special[3][0], Cords.special[3][1]);
        }

        if(useable_special[2] == 0){
            if(202 < X && X < 263 && 209 < Y && Y < 267){
                Game.batch.draw(GameSpecialHandler.hint2,GameSpecialHandler.x,GameSpecialHandler.y);
            }
            Game.batch.draw(monkeySwap, Cords.special[2][0], Cords.special[2][1]);
        }

        if(useable_special[4] == 0){
            if(739 < X && X < 797 && 367 < Y && Y < 426){
                Game.batch.draw(GameSpecialHandler.hint4,GameSpecialHandler.x,GameSpecialHandler.y);
            }
            Game.batch.draw(freeMove, Cords.special[4][0], Cords.special[4][1]);
        }

        if(selected_special != 99){
            Game.batch.draw(special_frame, Cords.special[selected_special][0] - (float)7, Cords.special[selected_special][1] - (float)7);
        }
        //------------ Special ----------------------


        //-------- Confirm Button ----------------------
        Confirm_button.draw();
        //-------- Confirm Button ----------------------


        //-------- Plus and Minus Button ----------------------
        if(phase == PHASE_MONKEY){
            if(selected_plus_or_minus == 99 || selectedMonkeyCards.size() != 2){
                Plus_Button.draw_dark();
                Minus_Button.draw_dark();
            }else if(selected_plus_or_minus == 0){
                Plus_Button.draw_bright();
                Minus_Button.draw_dark();
            }else if(selected_plus_or_minus == 1){
                Plus_Button.draw_dark();
                Minus_Button.draw_bright();
            }
        }
        //-------- Plus and Minus Button ----------------------


        //-------- Elephant Card ----------------------
        elephant1.draw();
        elephant2.draw();
        //-------- Elephant Card ----------------------


        //-------- Choose monkey ----------------------
        if(selected_special == 4){
            if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                for (int i =0; i<=20; i++){
                    if(Cords.cord[i][0] < X && X < Cords.cord[i][0] + 32 && Cords.cord[i][1] < Y && Y < Cords.cord[i][1] + 32){
                        selectedCord = i;
                    }
                }
            }

            String path = "img/"+selectedCord+".png";
            cord = new Texture(path);
            Game.batch.draw(cord,905,110);


            if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
                selectedIcon = 0;
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
                selectedIcon = 1;
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
                selectedIcon = 2;
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
                selectedIcon = 3;
            }

            if(selectedIcon == 2){
                Game.batch.draw(iconBlue,833,100);
            }
            if(selectedIcon == 3){
                Game.batch.draw(iconPink,833,100);
            }
            if(selectedIcon == 0){
                Game.batch.draw(iconOrange,833,100);
            }
            if(selectedIcon == 1){
                Game.batch.draw(iconGreen,833,100);
            }
        }
        //-------- Choose monkey ----------------------

    }

    public static void confirmSpecialPhase(){
        if(selected_special != 99){
            useable_special[selected_special] += 1;
        }
        if(selected_special == 4){
            monkeys[selectedIcon].move(selectedCord);
        }

        if(useable_special[5] == 1){

            for(int i = 0; i < 4; i++){
                currentPlayer.cards[i].pickFromDeck();
            }

            useable_special[5] += 1;
        }

        selected_special = 99;
        afterConfirm();
    }

    public static void confirmMonkeyPhase(){
        selected_plus_or_minus = 99;

        if (selectedMonkeyCards.size() == 1) {
            Card thisMonkeyCard = selectedMonkeyCards.get(0);
            int colorIndex = thisMonkeyCard.getColorIndex();
            monkeys[colorIndex].move(thisMonkeyCard.getNumber());
        }

        // Make the selected monkey cards disappear
        for(int i = 0; i < selectedMonkeyCards.size(); i++){
            selectedMonkeyCards.get(i).empty();
        }

        afterConfirm();
    }

    public static void confirmElephantPhase(){
        if(useable_special[3] == 1){
            Elephant.moveForward(elephant1.currentValue + elephant2.currentValue);

            Elephant_cards[0].turn += 1;
            Elephant_cards[1].turn += 1;

            useable_special[3] = 2;
        } else {
            if (Elephant_Card.selectedCard != null) {
                Elephant.moveForward(Elephant_Card.selectedCard.currentValue);
                Elephant_Card.selectedCard.flip();
                Elephant_Card.selectedCard = null;
            }
        }

        // Pick new monkey cards from the deck
        for(int i = 0; i < selectedMonkeyCards.size(); i++){
            selectedMonkeyCards.get(i).pickFromDeck();
        }
        selectedMonkeyCards = new ArrayList<>();


        currentPlayer.endTurn();
        currentPlayerIndex += 1;
        currentPlayerIndex = currentPlayerIndex % 4;
        currentPlayer = players[currentPlayerIndex];
        currentPlayer.startTurn();
        phase = -1;

        afterConfirm();
    }

    public static void afterConfirm(){
        if(useable_special[1] == 1){
            useable_special[1] = 2;
            selected_special = 99;
            currentPlayer.endTurn();
            currentPlayerIndex += 1;
            currentPlayerIndex = currentPlayerIndex % 4;
            currentPlayer = players[currentPlayerIndex];
            currentPlayer.startTurn();
            phase = 0;
            return;
        }else{
            if(phase != PHASE_MONKEY){
                phase = (phase + 1) % 3;
            }else{
                if(0 < selectedMonkeyCards.size() && selectedMonkeyCards.size() <= 2){
                    phase = (phase + 1) % 3;
                }
            }
        }

        if(useable_special[0] == 1){
            countTurn += 1;
        }
        if(0 < countTurn && countTurn < 6){
            currentWeight = 0;
            System.out.println(countTurn);
        }else{
            currentWeight = checkWeight();
        }


        if (currentWeight > maxWeight) {
            Game.endResult = "lose";
        }
    }

    public static double checkWeight(){
        elephant.scaleWeight();
        x_weight = elephant.x_weight;
        y_weight = elephant.y_weight;

        for (int i=0; i<4; i++){
            monkeys[i].scaleWeight();
            x_weight += monkeys[i].x_weight;
            y_weight += monkeys[i].y_weight;
        }

        return Math.sqrt(x_weight * x_weight + y_weight * y_weight);
    }

    public static void drawIndicatorLeaf(){
        int b = (int) ( ((x_weight/Math.abs(x_weight)) + 1)/2 );
        int a = (int) ( ((y_weight/Math.abs(y_weight)) + 1)/2 );
        if (currentWeight > maxWeight*0.75) {
            Game.batch.draw(Cords.leaf_asset[a][b][2],0,0);
            Game.batch.draw(Cords.leaf_asset[(a+1)%2][b][1],0,0);
            Game.batch.draw(Cords.leaf_asset[a][(b+1)%2][1], 0, 0);
        } else if (currentWeight > maxWeight*0.5) {
            Game.batch.draw(Cords.leaf_asset[a][b][1],0,0);
        }
    }

    public static void dispose(){
        cordMap.dispose();
        pink.dispose();
        blue.dispose();
        green.dispose();
        orange.dispose();
        Elephant.dispose();
        holdOn.dispose();
        breakTime.dispose();
        monkeySwap.dispose();
        turboElephant.dispose();
        freeMove.dispose();
        exchange.dispose();
        Plus_Button.dispose();
        Minus_Button.dispose();
        Confirm_button.dispose();
        elephant1.dispose();
        elephant2.dispose();
        iconBlue.dispose();
        iconGreen.dispose();
        iconOrange.dispose();
        iconPink.dispose();
    }

}
