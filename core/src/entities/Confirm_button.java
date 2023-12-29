package entities;

import static managers.PlayStateController.currentPlayer;
import static managers.PlayStateController.currentPlayerIndex;
import static managers.PlayStateController.phase;
import static managers.PlayStateController.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Confirm_button {
    public static float x = 831;
    public static float y = 47;

    public static Texture btn = new Texture("img/button_confirm.png");

    public static void confirm_click(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(x < X && X < x + 130 && y < Y && Y < y + 42 ){
                System.out.println("Current phase is: "+phase);
                phase = phase + 1;
                if(phase == 3){
                    currentPlayer.endTurn();
                    currentPlayerIndex += 1;
                    currentPlayerIndex = currentPlayerIndex % 4;
                    currentPlayer = players[currentPlayerIndex];
                    currentPlayer.startTurn();
                    phase = 0;
                }
            }
        }
    }
}
