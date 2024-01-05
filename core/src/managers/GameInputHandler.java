package managers;

import static managers.PlayStateController.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;

import managers.PlayStateController.*;

public class GameInputHandler {

    static Sound select = Gdx.audio.newSound(Gdx.files.internal("sound/se/select.mp3"));
    static Sound deselect = Gdx.audio.newSound(Gdx.files.internal("sound/se/deselect.mp3"));

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

            if(useable_special[0]){
                if(202 < X && X < 263 && 529 < Y && Y < 583){
                    if(selected_special == 0){
                        selected_special = 99;
                        deselect.play(0.1f);
                    }
                    else{
                        selected_special = 0;
                        select.play(0.1f);
                    }


                }
            }


            if(useable_special[1]){
            if(202 < X && X < 263 && 367 < Y && Y < 426){
                if(selected_special == 1){
                    selected_special = 99;
                    deselect.play(0.1f);
                }
                else{
                    selected_special = 1;
                    select.play(0.1f);
                }

            }}

            if(useable_special[2]){
            if(202 < X && X < 263 && 209 < Y && Y < 267){
                if(selected_special == 2){
                    selected_special = 99;
                    deselect.play(0.1f);
                }
                else{
                    selected_special = 2;
                    select.play(0.1f);
                }

            }}

            if(useable_special[3]){
            if(739 < X && X < 797 && 529 < Y && Y < 583){
                if(selected_special == 3){
                    selected_special = 99;
                    deselect.play(0.1f);
                }
                else{
                    selected_special = 3;
                    select.play(0.1f);
                }

            }}

            if(useable_special[4]){
            if(739 < X && X < 797 && 367 < Y && Y < 426){
                if(selected_special == 4){
                    selected_special = 99;
                    deselect.play(0.1f);
                }
                else{
                    selected_special = 4;
                    select.play(0.1f);
                }

            }}

            if(useable_special[5]){
            if(739 < X && X < 797 && 209 < Y && Y < 267){
                if(selected_special == 5){
                    selected_special = 99;
                    deselect.play(0.1f);
                }
                else{
                    selected_special = 5;
                    select.play(0.1f);
                }

            }}
        }
    }

    public static void dispose(){
        select.dispose();
        deselect.dispose();
    }

}
