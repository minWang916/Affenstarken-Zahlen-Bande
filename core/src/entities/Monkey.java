package entities;

import com.badlogic.gdx.graphics.Texture;

public class Monkey {

    public int location;
    public String color;
    public String path;

    public Texture img;

    public int weight = 3;

    public Monkey(String color){
        this.location = 0;
        this.color = color;
        this.path = "img/monkey_"+ color +".png";
        this.img = new Texture(this.path);

    }

    public void move(int location){
        this.location = location;
    }

    public void dispose(){
        img.dispose();
    }
}
