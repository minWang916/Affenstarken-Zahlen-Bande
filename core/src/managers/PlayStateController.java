package managers;

import com.badlogic.gdx.Gdx;
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
    public static int activeSpecial = -1;
    public static int numOfPlayers = 4;
    public static Player currentPlayer;
    public static int currentPlayerIndex = 0;
    public static Player[] players = new Player[4];
    public static boolean selected = false;
    public static int selectedSign = 1;
    public static Monkey blue = new Monkey("blue");
    public static Monkey orange = new Monkey("orange");
    public static Monkey pink = new Monkey("pink");
    public static Monkey green = new Monkey("green");
    public static Monkey[] monkeys = new Monkey[]{orange, green, blue, pink};

    public static Elephant elephant = new Elephant();

    public static final Texture holdOn = new Texture("img/special_1.png");
    public static final Texture breakTime = new Texture("img/special_2.png");
    public static final Texture monkeySwap = new Texture("img/special_3.png");
    public static final Texture turboElephant = new Texture("img/special_4.png");
    public static final Texture freeMove = new Texture("img/special_5.png");
    public static final Texture exchange = new Texture("img/special_6.png");
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
    public static SignButton[] signButtons;



    public static void init(String[] usernames, int[] avatars){
        //-------------------- Entities------------------------------------------
        System.out.println(Cords.xWeightSign.length);
        System.out.println(Cords.yWeightSign.length);
        assistant = new PlayerAssistant();
        SignButton minusBtn = new SignButton(-1);
        SignButton plusBtn = new SignButton(1);
        signButtons = new SignButton[]{minusBtn, plusBtn};
        //-------------------- Entities------------------------------------------

        //------------------- Turn based-----------------------------------------
        String[] playerNames = usernames;
        for(int i = 0; i< 4; i++){
            players[i] = new Player(playerNames[i], avatars[i], i, Game.batch);
        }

        currentPlayer = players[currentPlayerIndex];
        currentPlayer.startTurn();
        //------------------- Turn based-----------------------------------------
    }

    public static void handleInput(){

        if(phase == PHASE_SPECIAL){
            GameSpecialHandler.special();
        }else if(phase == PHASE_MONKEY){

        }else if(phase == PHASE_ELEPHANT){
            elephant2.handleClick();
            elephant1.handleClick();
        }

    }

    public static void update(){

        handleInput();

        //---------- Leaves -----------------------

        //---------- Leaves ------------------------


        //---- Monkeys and elephant-----------------
        Elephant.checkWin();
        //---- Monkeys and elephant-----------------


        //--- Player (and cards - inside players)----
        for (int i = 0; i<4; i++){
            players[i].update();
        }
        //--- Player (and cards - inside players)----

        //------ Game buttons------------------------
        Confirm_button.update();
        signButtons[0].update();
        signButtons[1].update();
        //------ Game buttons------------------------


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
                if(Game.language == "en") {
                    Game.batch.draw(GameSpecialHandler.hint0, GameSpecialHandler.x, GameSpecialHandler.y);
                }else{
                    Game.batch.draw(GameSpecialHandler.hint0de, GameSpecialHandler.x, GameSpecialHandler.y);
                }
            }
            Game.batch.draw(holdOn, Cords.special[0][0], Cords.special[0][1]);
        }

        if(useable_special[1] == 0){
            if(202 < X && X < 263 && 367 < Y && Y < 426){
                Game.batch.draw(GameSpecialHandler.hint1,GameSpecialHandler.x,GameSpecialHandler.y);
                if(Game.language == "en") {
                    Game.batch.draw(GameSpecialHandler.hint1, GameSpecialHandler.x, GameSpecialHandler.y);
                }else{
                    Game.batch.draw(GameSpecialHandler.hint1de, GameSpecialHandler.x, GameSpecialHandler.y);
                }
            }
            Game.batch.draw(breakTime, Cords.special[1][0], Cords.special[1][1]);
        }

        if(useable_special[5] == 0){
            if(739 < X && X < 797 && 209 < Y && Y < 267){
                Game.batch.draw(GameSpecialHandler.hint5,GameSpecialHandler.x,GameSpecialHandler.y);
                if(Game.language == "en") {
                    Game.batch.draw(GameSpecialHandler.hint5, GameSpecialHandler.x, GameSpecialHandler.y);
                }else{
                    Game.batch.draw(GameSpecialHandler.hint5de, GameSpecialHandler.x, GameSpecialHandler.y);
                }
            }
            Game.batch.draw(exchange, Cords.special[5][0], Cords.special[5][1]);
        }

        if(useable_special[3] == 0){
            if(739 < X && X < 797 && 529 < Y && Y < 583){
                Game.batch.draw(GameSpecialHandler.hint3,GameSpecialHandler.x,GameSpecialHandler.y);
                if(Game.language == "en") {
                    Game.batch.draw(GameSpecialHandler.hint3, GameSpecialHandler.x, GameSpecialHandler.y);
                }else{
                    Game.batch.draw(GameSpecialHandler.hint3de, GameSpecialHandler.x, GameSpecialHandler.y);
                }
            }
            Game.batch.draw(turboElephant, Cords.special[3][0], Cords.special[3][1]);
        }

        if(useable_special[2] == 0){
            if(202 < X && X < 263 && 209 < Y && Y < 267){
                Game.batch.draw(GameSpecialHandler.hint2,GameSpecialHandler.x,GameSpecialHandler.y);
                if(Game.language == "en") {
                    Game.batch.draw(GameSpecialHandler.hint2, GameSpecialHandler.x, GameSpecialHandler.y);
                }else{
                    Game.batch.draw(GameSpecialHandler.hint2de, GameSpecialHandler.x, GameSpecialHandler.y);
                }
            }
            Game.batch.draw(monkeySwap, Cords.special[2][0], Cords.special[2][1]);
        }

        if(useable_special[4] == 0){
            if(739 < X && X < 797 && 367 < Y && Y < 426){
                Game.batch.draw(GameSpecialHandler.hint4,GameSpecialHandler.x,GameSpecialHandler.y);
                if(Game.language == "en") {
                    Game.batch.draw(GameSpecialHandler.hint4, GameSpecialHandler.x, GameSpecialHandler.y);
                }else{
                    Game.batch.draw(GameSpecialHandler.hint4de, GameSpecialHandler.x, GameSpecialHandler.y);
                }
            }
            Game.batch.draw(freeMove, Cords.special[4][0], Cords.special[4][1]);
        }

        if(selected_special != 99){
            Game.batch.draw(special_frame, Cords.special[selected_special][0] - (float)7, Cords.special[selected_special][1] - (float)7);
        }
        //------------ Special ----------------------


        //------ Game buttons------------------------
        Confirm_button.draw();
        signButtons[0].draw();
        signButtons[1].draw();
        //------ Game buttons------------------------


        //-------- Elephant Card ----------------------
        elephant1.draw();
        elephant2.draw();
        //-------- Elephant Card ----------------------


        //-------- Choose monkey ----------------------
        if(selected_special == 4 || selected_special == 2){
            if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                for (int i =0; i<=20; i++){
                    if(Cords.cord[i][0] < X && X < Cords.cord[i][0] + 40 && Cords.cord[i][1] < Y && Y < Cords.cord[i][1] + 40){
                        selectedCord = i;
                    }
                }
            }

            String path = "img/"+selectedCord+".png";
            cord = new Texture(path);
            if (selected_special == 4)
            { Game.batch.draw(cord,905,110); }


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

        if (selected_special == 2) {
            activeSpecial = 2;
            System.out.println("Active special 2");
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

        if (selectedMonkeyCards.size() == 1) {
            Card selectedCard = selectedMonkeyCards.get(0);
            int colorIndex = selectedCard.getColorIndex();
            monkeys[colorIndex%4].move(selectedCard.getNumber());
        } else if (selectedMonkeyCards.size() == 2) {
            System.out.println("Selected 2 monkey cards");
            Card selectedCard1 = selectedMonkeyCards.get(0);
            Card selectedCard2 = selectedMonkeyCards.get(1);
            int colorIndex = selectedCard1.getColorIndex();
            if (activeSpecial == 2) {
                colorIndex = selectedIcon;
                System.out.println("The effective color is " + Cords.colors[colorIndex]);
            }
            if (selectedSign == 1) {
                int location = selectedCard1.getNumber() + selectedCard2.getNumber();
                monkeys[colorIndex].move(location);
                System.out.println("The new location is the sum: " + location);
            } else {
                int location = Math.abs(selectedCard1.getNumber() - selectedCard2.getNumber());
                monkeys[colorIndex].move(location);
                System.out.println("The new location is the subtraction: " + location);
            }
        } else {
            System.out.println("Error: the number of cards is not 1 or 2");
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

            Elephant_cards[0].flip();
            Elephant_cards[1].flip();

            useable_special[3] = 2;
        } else {
            if (Elephant_Card.selectedCard != null) {
                Elephant.moveForward(Elephant_Card.selectedCard.currentValue);
                Elephant_Card.selectedCard.flip();
                Elephant_Card.selectedCard = null;
            }
        }

        // Pick new monkey cards from the deck replacing the selected ones
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
        activeSpecial = -1;

        afterConfirm();
        activeSpecial = -1;
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
            for(int i = 0; i < 4; i++){
                players[i].endTurn();
            }
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

    }

}
