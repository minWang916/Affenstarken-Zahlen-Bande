package entities;


import static managers.PlayStateController.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import entities.*;

public class Confirm_button {
    public static float x = 831;
    public static float y = 47;



    public static Texture btn = new Texture("img/button_confirm.png");
    public static Texture btnDark = new Texture("img/button_confirm_dark.png");

    static Sound btnSound = Gdx.audio.newSound(Gdx.files.internal("sound/se/confirm.mp3"));

    public static void confirm_click(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){

            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(x < X && X < x + 130 && y < Y && Y < y + 42 ){


                if(phase == PHASE_SPECIAL){

                    if(selected_special != 99){
                        useable_special[selected_special] = 1;
                    }
                    selected_special = 99;

                }

                if(phase == PHASE_MONKEY){
                    if(Card.totalSelected > 2){

                    }
                    selected_plus_or_minus = 99;

                }

                if(phase == PHASE_ELEPHANT){

                    if(useable_special[3] == 1){
                        int valueLeft = 0;
                        int valueRight = 0;
                        if(Elephant_cards[0].turn % 2 == 0){
                            valueLeft = Elephant_cards[0].value1;
                        }else{
                            valueLeft = Elephant_cards[0].value2;
                        }

                        if(Elephant_cards[1].turn % 2 == 0){
                            valueRight = Elephant_cards[1].value1;
                        }else{
                            valueRight = Elephant_cards[1].value2;
                        }

                        Elephant_cards[0].turn += 1;
                        Elephant_cards[1].turn += 1;

                        Elephant.move(Elephant.location + valueLeft + valueRight);
                        useable_special[3] = 2;
                    }else {

                        if (Elephant_Card.selected != 99) {
                            if (Elephant_cards[Elephant_Card.selected].turn % 2 == 0) {
                                Elephant.move(Elephant.location + Elephant_cards[Elephant_Card.selected].value1);
                                Elephant_cards[Elephant_Card.selected].turn = Elephant_cards[Elephant_Card.selected].turn + 1;
                            } else {
                                Elephant.move(Elephant.location + Elephant_cards[Elephant_Card.selected].value2);
                                Elephant_cards[Elephant_Card.selected].turn = Elephant_cards[Elephant_Card.selected].turn + 1;
                            }

                            Elephant_Card.selected = 99;
                        }
                    }


                    currentPlayer.endTurn();
                    currentPlayerIndex += 1;
                    currentPlayerIndex = currentPlayerIndex % 4;
                    currentPlayer = players[currentPlayerIndex];
                    currentPlayer.startTurn();
                    phase = -1;
                }


                if(useable_special[1] == 1){
                    btnSound.play(0.2f);
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
                        btnSound.play(0.2f);
                        phase = (phase + 1) % 3;
                    }else{
                        if(0 < Card.totalSelected && Card.totalSelected <= 2){
                            btnSound.play(0.2f);
                            phase = (phase + 1) % 3;
                            Card.totalSelected = 0;
                            for(int i = 0; i < Cards.size(); i++){
                                Cards.get(i).selected = false;
                            }
                        }
                    }

                }
            }
        }
    }

    public static void dispose(){
        btn.dispose();
        btnSound.dispose();
        btnDark.dispose();
    }
}
