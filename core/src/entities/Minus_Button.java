package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

public class Minus_Button {
    public static float x = 895;
    public static float y = 95;
    public static Texture minus_img = new Texture("img/minus.png");

    public static void draw(){
        Game.batch.draw(minus_img,x,y);
    }

    public static void handleClick(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(x < X && X < x + 68 && y < Y && Y < y + 48){
                System.out.println("Minus");
            }
        }
    }

    public static void dispose(){
        minus_img.dispose();
    }
}
