package entities;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

public class Elephant {
    public double weight = 50;

    public double x_weight;
    public double y_weight;

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

    public void scaleWeight(){

        if (location <= 4) {
            x_weight = weight / Math.sqrt(2);
            y_weight = weight / Math.sqrt(2);
        } else if (location <= 12) {
            x_weight = (weight*1.5) / Math.sqrt(2);
            y_weight = (weight*1.5) / Math.sqrt(2);
        } else {
            x_weight = (weight*2) / Math.sqrt(2);
            y_weight = (weight*2) / Math.sqrt(2);
        }
        x_weight *= Cords.xWeightSign[location];
        y_weight *= Cords.yWeightSign[location];
    }

    public static void dispose() {
        img.dispose();
    }
}
