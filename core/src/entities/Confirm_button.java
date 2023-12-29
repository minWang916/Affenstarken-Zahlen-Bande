package entities;


import static managers.PlayStateController.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import entities.*;

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
                if(phase == PHASE_SPECIAL){
                    if(selected_special != 99){
                        useable_special[selected_special] = false;
                    }
                    selected_special = 99;
                }
                phase = phase + 1;
                if(phase == 3){
                    if(Elephant_Card.selected != 99){
                        if(Elephant_cards[Elephant_Card.selected].turn % 2 == 0){
                            Elephant.move(Elephant.location + Elephant_cards[Elephant_Card.selected].value1);
                            Elephant_cards[Elephant_Card.selected].turn = Elephant_cards[Elephant_Card.selected].turn + 1;
                        }else{
                            Elephant.move(Elephant.location + Elephant_cards[Elephant_Card.selected].value2);
                            Elephant_cards[Elephant_Card.selected].turn = Elephant_cards[Elephant_Card.selected].turn + 1;
                        }

                        Elephant_Card.selected = 99;
                    }
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
