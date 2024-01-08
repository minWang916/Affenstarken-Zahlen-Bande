package entities;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

public class Monkey {

    public int location;
    public String color;
    public String path;

    public Texture img;

    public int weight = 20;
    public double x_weight;
    public double y_weight;

    public Monkey(String color){
        this.location = 0;
        this.color = color;
        this.path = "img/monkey_"+ color +".png";
        this.img = new Texture(this.path);

    }

    public void move(int newLocation){
        location = newLocation;
    }

    public void moveForward(int step) { location = location + step; }

    public void draw(){
        Game.batch.draw(img, Cords.cord[location][0],Cords.cord[location][1]);
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
        x_weight = scaledWeight * Cords.xWeightSign[location];
        y_weight = scaledWeight * Cords.yWeightSign[location];
    }

    public void dispose(){
        img.dispose();
    }
}
