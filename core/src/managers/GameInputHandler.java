package managers;

import static managers.PlayStateController.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;


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

    public static void confirm(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(849 < X && X < 950 && 105 < Y && Y < 136){
                System.out.println("Confirmed");
            }
        }
    }

}
