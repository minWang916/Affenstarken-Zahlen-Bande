package entities;

import static managers.PlayStateController.selected;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;


public class Elephant_Card {

    public int value1;
    public int value2;

    private int turn = 3;

    public Texture face1;
    public Texture face2;

    public float x;
    public float y;

    public Elephant_Card(int value1, int value2, String path1, String path2, float x, float y){
        this.value1 = value1;
        this.value2 = value2;

        this.face1 = new Texture(path1);
        this.face2 = new Texture(path2);

        this.x = x;
        this.y = y;
    }

    public void draw(){
        if(turn % 2 == 0){
            Game.batch.draw(face1, x, y);
        }else{
            Game.batch.draw(face2, x, y);
        }
    }

    public void handleClick(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float X = Gdx.input.getX();
            float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(x < X && X < x + 68 && y < Y && Y < y + 100){
                if(turn % 2 == 0){
                    Elephant.move(Elephant.location+value1);
                    turn = turn + 1;
                }else{
                    Elephant.move(Elephant.location+value2);
                    turn = turn + 1;
                }


            }
        }
    }
}

