package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

public class Plus_Button {

    public static float x = 820;
    public static float y = 95;
    public static Texture plus_img = new Texture("img/plus.png");

    public static void draw(){
        Game.batch.draw(plus_img,x,y);
    }

    public static void handleClick(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(x < X && X < x + 68 && y < Y && Y < y + 48){
                System.out.println("Plus");
            }
        }
    }

    public static void dispose(){
        plus_img.dispose();
    }
}
