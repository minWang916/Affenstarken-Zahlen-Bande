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

    public static void move(int newLocation){
        if(newLocation > 20){
            location = 20;
        }else {
            location = newLocation;
        }
        checkWin();
    }

    public static void moveForward(int step){
        location = Math.min(location + step, 20);
    }

    public static void checkWin(){
        if(location == 20){
            Game.endResult = "win";
        }
    }

    public static void draw() {
        Game.batch.draw(img, Cords.cord[location][0], Cords.cord[location][1]);
    }

    public void scaleWeight(){
        double scaledWeight;
        if (location <= 4) {
            scaledWeight = weight;
        } else if (location <= 12) {
            scaledWeight = weight*1.5;
        } else {
            scaledWeight = weight*2;
        }
        x_weight = scaledWeight * Cords.xWeightSign[location % 21];
        y_weight = scaledWeight * Cords.yWeightSign[location % 21];
    }

    public static void dispose() {
        img.dispose();
    }
}
