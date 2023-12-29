package managers;

import static managers.PlayStateController.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import managers.PlayStateController.*;

public class GameInputHandler {

    public static void bottom_card_1(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(360 < X && X < 427 && 37 < Y && Y < 137){
                if(selected == false){
                    selected = true;
                }else{
                    selected = false;
                }
            }
        }
    }



    public static void special(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            System.out.println("Mouse: "+X+" "+ Y);
            if(202 < X && X < 263 && 529 < Y && Y < 583){
                useable_holdOn = false;
            }

            if(202 < X && X < 263 && 367 < Y && Y < 426){
                useable_breakTime = false;
            }

            if(202 < X && X < 263 && 209 < Y && Y < 267){
                useable_monkeySwap = false;
            }

            if(739 < X && X < 797 && 529 < Y && Y < 583){
                useable_turboElephant = false;
            }

            if(739 < X && X < 797 && 367 < Y && Y < 426){
                useable_freeMove = false;
            }

            if(739 < X && X < 797 && 209 < Y && Y < 267){
                useable_exchange = false;
            }
        }
    }

}
