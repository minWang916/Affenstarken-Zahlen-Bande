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

    public void move(int location){
        this.location = location;
    }

    public void draw(){
        Game.batch.draw(img, Cords.cord[location][0],Cords.cord[location][1]);
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

    public void dispose(){
        img.dispose();
    }
}
