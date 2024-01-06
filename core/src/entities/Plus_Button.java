package entities;

//import static managers.PlayStateController.selected_plus_or_minus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

public class Plus_Button {

    public static float x = 820;
    public static float y = 95;
    public static Texture plus_img = new Texture("img/plus_bright.png");
    public static Texture plus_img_dark = new Texture("img/plus_dark.png");

    public static void draw_bright(){
        Game.batch.draw(plus_img,x,y);
    }
    public static void draw_dark(){
        Game.batch.draw(plus_img_dark,x,y);
    }

    public static void handleClick(){
//        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
//            float X = Gdx.input.getX();
//            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
//            if(x < X && X < x + 68 && y < Y && Y < y + 48){
//                if(selected_plus_or_minus == 0){
//                    selected_plus_or_minus = 99;
//                }else{
//                    selected_plus_or_minus = 0;
//                }
//            }
//        }
    }

    public static void dispose(){
        plus_img.dispose();
        plus_img_dark.dispose();
    }
}
