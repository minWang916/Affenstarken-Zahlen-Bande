package entities;

import static managers.PlayStateController.selected;
import static managers.PlayStateController.useable_special;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;


public class Elephant_Card {
    public int id;

    public static Elephant_Card selectedCard = null;

    public int[] values = new int[2];
    public int currentValue;
    public int turn;

    public Texture[] faces = new Texture[2];
    public static Texture background = new Texture("img/card_asset/elephant_card_background.png");
    public static Texture elephant_pic = new Texture("img/card_asset/elephant.png");
    public static Texture elephant_frame = new Texture("img/frame_h.png");
    public float x;
    public float y;

    public Elephant_Card(int value1, int value2, String path1, String path2, float x, float y, int id){
        this.values = new int[]{value1, value2};
        this.turn = 0;
        this.currentValue = value1;
        Texture face1 = new Texture(path1);
        Texture face2 = new Texture(path2);
        this.faces = new Texture[]{face1, face2};
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public void draw(){
        Game.batch.draw(background, x, y);
        Game.batch.draw(elephant_pic, x, y);
        Game.batch.draw(faces[turn], x, y);
        if (selectedCard == this){
            Game.batch.draw(elephant_frame, x-9, y-9);
        }
    }

    public void handleClick(){
        if(useable_special[3] != 1){
            if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                float X = Gdx.input.getX();
                float Y = Gdx.graphics.getHeight() - Gdx.input.getY();
                if(this.x < X && X < this.x + background.getWidth() && this.y < Y && Y < this.y + background.getHeight()){
                    if(selectedCard == this){
                        selectedCard = null;
                        Cords.selectSound.play(0.3f*Game.sfxVolume*Game.masterVolume/10);
                    }else{
                        selectedCard = this;
                        Cords.unselectSound.play(0.3f*Game.sfxVolume*Game.masterVolume/10);
                    }
                }
            }
        }

    }

    public void flip(){
        turn = (turn + 1) % 2;
        currentValue = values[turn];
    }

    public void dispose() {
        background.dispose();
        elephant_frame.dispose();
        elephant_pic.dispose();
        faces[0].dispose();
        faces[1].dispose();
    }
}

