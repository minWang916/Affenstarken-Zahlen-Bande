package entities;

import static managers.PlayStateController.selected;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;


public class Elephant_Card {
    public int id;

    public Sound select = Gdx.audio.newSound(Gdx.files.internal("sound/se/select.mp3"));
    public Sound deselect = Gdx.audio.newSound(Gdx.files.internal("sound/se/deselect.mp3"));

    public static int selected = 99;

    public int value1;
    public int value2;

    public int turn = 3;

    public Texture face1;
    public Texture face2;

    public float x;
    public float y;

    public Elephant_Card(int value1, int value2, String path1, String path2, float x, float y, int id){
        this.value1 = value1;
        this.value2 = value2;

        this.face1 = new Texture(path1);
        this.face2 = new Texture(path2);

        this.x = x;
        this.y = y;

        this.id = id;
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
            if(this.x < X && X < this.x + 68 && this.y < Y && Y < this.y + 100){

                if(selected == this.id){
                    selected = 99;
                    deselect.play(0.1f);
                }else{
                    selected = this.id;
                    select.play(0.1f);
                }

                /*
                if(turn % 2 == 0){
                    Elephant.move(Elephant.location+value1);
                    turn = turn + 1;
                }else{
                    Elephant.move(Elephant.location+value2);
                    turn = turn + 1;
                }
                */



            }
        }
    }

    public void dispose() {
        face1.dispose();
        face2.dispose();

        select.dispose();
        deselect.dispose();
    }
}

