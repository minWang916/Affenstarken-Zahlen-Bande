package entities;

//import static managers.PlayStateController.selected_plus_or_minus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

public class Minus_Button {
    public static float x = 895;
    public static float y = 95;
    public static Texture minus_img = new Texture("img/minus_bright.png");
    public static Texture minus_img_dark = new Texture("img/minus_dark.png");

    public static void draw_bright(){
        Game.batch.draw(minus_img,x,y);
    }
    public static void draw_dark(){
        Game.batch.draw(minus_img_dark,x,y);
    }

    public static void handleClick(){
//        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
//            float X = Gdx.input.getX();
//            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
//            if(x < X && X < x + 68 && y < Y && Y < y + 48){
//                if(selected_plus_or_minus == 1){
//                    selected_plus_or_minus = 99;
//                }else{
//                    selected_plus_or_minus = 1;
//                }
//            }
//        }
    }

    public static void dispose(){
        minus_img.dispose();
        minus_img_dark.dispose();
    }
}
