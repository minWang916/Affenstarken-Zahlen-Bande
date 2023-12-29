package entities;

import com.badlogic.gdx.graphics.Texture;

public class Elephant {
    public static int location = 0;
    public static String path = "img/elephant.png";

    public static Texture img = new Texture(path);

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
}
