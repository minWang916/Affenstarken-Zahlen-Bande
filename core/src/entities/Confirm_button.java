package entities;


import static managers.PlayStateController.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;
import entities.*;
import managers.PlayStateController;

public class Confirm_button {
    public static float x = 827;
    public static float y = 47;
    public static Texture btnTexture = new Texture("img/button_confirm.png");
    public static Texture darkBtnTexture = new Texture("img/button_confirm_dark.png");
    public static boolean active = true;

    public static void update(){
        if(phase == PHASE_SPECIAL){

        } else if (phase == PHASE_MONKEY){
            updateInMonkeyPhase();
        } else if (phase == PHASE_ELEPHANT){

        } else {
            System.out.println("Current phase is: " + phase);
        }
        handleInput();
    }

    public static void updateInMonkeyPhase(){
        if (selectedMonkeyCards.size() > 2 || selectedMonkeyCards.size() < 1) {
            //More than 2 or fewer than 1 monkey cards are selected
            active = false;
        } else if (selectedMonkeyCards.size() == 1){
            //Exactly 1 monkey card is selected
            active = true;
        } else if (selectedMonkeyCards.size() == 2) {
            //Exactly 2 monkey cards are selected
            Card selectedCard1 = selectedMonkeyCards.get(0);
            Card selectedCard2 = selectedMonkeyCards.get(1);
            if (selectedCard1.getColorIndex() == selectedCard2.getColorIndex()){
                if (selectedSign == 1 && selectedCard1.getNumber() + selectedCard2.getNumber() > 20) {
                    active = false;
                } else {
                    active = true;
                }
            } else {
                active = false;
            }
        }

    }

    public static void handleInput(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(x < X && X < x + btnTexture.getWidth() &&
                    y < Y && Y < y + btnTexture.getHeight() && active == true){
                handleConfirm();
            }
        }
    }

    public static void handleConfirm(){
        Cords.btnSound.play(0.2f);
        if(phase == PHASE_SPECIAL){
            PlayStateController.confirmSpecialPhase();
        } else if (phase == PHASE_MONKEY){
            PlayStateController.confirmMonkeyPhase();
        } else if (phase == PHASE_ELEPHANT){
            PlayStateController.confirmElephantPhase();
        } else {
            System.out.println("Current phase is: " + phase);
        }
    }

    public static void draw(){
        if (active == true) {
            Game.batch.draw(btnTexture, x, y);
        } else {
            Game.batch.draw(darkBtnTexture, x, y);
        }
    }

    public static void dispose(){
        btnTexture.dispose();
        darkBtnTexture.dispose();
    }
}
