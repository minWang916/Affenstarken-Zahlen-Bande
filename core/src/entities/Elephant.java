package entities;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

public class Elephant {
    public int weight = 50;
    public static int location = 0;
    public static String path = "img/elephant.png";

    public static Texture img = new Texture(path);

    public static void Elephant(){

    }

    public static void move(int new_location){
        location = new_location;
    }

    public static boolean checkWin(){
        if(location == 20){
            return true;
        }else{
            return false;
        }

    }

    public static void draw() {
        Game.batch.draw(img, Cords.cord[location][0], Cords.cord[location][1]);
    }

    public static void dispose() {
        img.dispose();
    }
}
