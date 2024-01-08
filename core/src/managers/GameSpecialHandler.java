package managers;

import static managers.PlayStateController.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

import managers.PlayStateController.*;

public class GameSpecialHandler {

    static Sound select = Gdx.audio.newSound(Gdx.files.internal("sound/se/select.mp3"));
    static Sound deselect = Gdx.audio.newSound(Gdx.files.internal("sound/se/deselect.mp3"));
    static Texture hint0 = new Texture("img/hint0.png");
    static Texture hint1 = new Texture("img/hint1.png");
    static Texture hint2 = new Texture("img/hint2.png");
    static Texture hint3 = new Texture("img/hint3.png");
    static Texture hint4 = new Texture("img/hint4.png");
    static Texture hint5 = new Texture("img/hint5.png");


    static float x = 340;
    static float y = 275;


    public static void special(){

            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();

            if(useable_special[0]  == 0){

                if(202 < X && X < 263 && 529 < Y && Y < 583){



                    if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {

                        if (selected_special == 0) {
                            selected_special = 99;
                            deselect.play(0.1f);
                        } else {
                            selected_special = 0;
                            select.play(0.1f);
                        }

                    }
                }
            }


            if(useable_special[1] == 0){
            if(202 < X && X < 263 && 367 < Y && Y < 426){
                if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                if(selected_special == 1){
                    selected_special = 99;
                    deselect.play(0.1f);
                }
                else{
                    selected_special = 1;
                    select.play(0.1f);
                }

            }}}

            if(useable_special[2] == 0){
            if(202 < X && X < 263 && 209 < Y && Y < 267){
                if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                if(selected_special == 2){
                    selected_special = 99;
                    deselect.play(0.1f);
                }
                else{
                    selected_special = 2;
                    select.play(0.1f);
                }

            }}}

            if(useable_special[3] == 0){
            if(739 < X && X < 797 && 529 < Y && Y < 583){
                if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                if(selected_special == 3){
                    selected_special = 99;
                    deselect.play(0.1f);
                }
                else{
                    selected_special = 3;
                    select.play(0.1f);
                }

            }}}

            if(useable_special[4] == 0){
            if(739 < X && X < 797 && 367 < Y && Y < 426){
                if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                if(selected_special == 4){
                    selected_special = 99;
                    deselect.play(0.1f);
                }
                else{
                    selected_special = 4;
                    select.play(0.1f);
                }

            }}}

            if(useable_special[5] == 0){
            if(739 < X && X < 797 && 209 < Y && Y < 267){
                if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                if(selected_special == 5){
                    selected_special = 99;
                    deselect.play(0.1f);
                }
                else{
                    selected_special = 5;
                    select.play(0.1f);
                }

            }}}
        }


    public static void dispose(){
        select.dispose();
        deselect.dispose();
    }

}
