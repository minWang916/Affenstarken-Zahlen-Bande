package entities;

import managers.PlayStateController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

import managers.PlayStateController;

public class SignButton {

    private float x;
    private float y;
    private Texture[] btnTexture;
    private boolean select = false;
    private boolean appear = false;
    private int sign;

    public SignButton(int sign){
        this.sign = sign;
        // If sign is -1, index is 0 (minus); If is 1, index is 1 (plus)
        int index = (int) ((sign + 1)/2);
        x = Cords.signBtnCord[index][0];
        y = Cords.signBtnCord[index][1];
        btnTexture = new Texture[]{Cords.signBtnTexture[index][0], Cords.signBtnTexture[index][1]};
    }
    public void update(){
        appear = false;
        //Only appear if in Monkey phase with exactly 2 cards selected
        if (PlayStateController.phase == PlayStateController.PHASE_MONKEY) {
            if (PlayStateController.selectedMonkeyCards.size() == 2){
                appear = true;
            }
        }

        select = false;
        if (PlayStateController.selectedSign == sign) {
            select = true;
        }

        handleClick();
    }
    public void draw(){
        if (appear == true) {
            if (select == true)
                Game.batch.draw(btnTexture[0], x, y);
            else
                Game.batch.draw(btnTexture[1], x, y);
        }
    }


    public void handleClick(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(x < X && X < x + btnTexture[0].getWidth()
                    && y < Y && Y < y + btnTexture[0].getHeight() && appear == true){
                PlayStateController.selectedSign = sign;
                System.out.println("Selected sign is " + PlayStateController.selectedSign);
            }
        }
    }

    public void toggleSelect(){
        if (select == true) {
            select = false;
        } else {
            select = true;
        }
    }

    public static void dispose(){

    }
}
