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
    public static Texture btn = new Texture("img/button_confirm.png");
    public static Texture btnDark = new Texture("img/button_confirm_dark.png");
    public static float width = btn.getWidth();
    public static float height = btn.getHeight();

    public static void handleInput(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(x < X && X < x + width && y < Y && Y < y + height ){
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
        if(phase != PHASE_MONKEY){
            Game.batch.draw(Confirm_button.btn, Confirm_button.x, Confirm_button.y);
        }else{
            if(0 < selectedMonkeyCards.size() && selectedMonkeyCards.size() <= 2){
                Game.batch.draw(Confirm_button.btn, Confirm_button.x, Confirm_button.y);
            }else{
                Game.batch.draw(Confirm_button.btnDark, Confirm_button.x, Confirm_button.y);
            }
        }
    }

    public static void dispose(){
        btn.dispose();
        btnDark.dispose();
    }
}
