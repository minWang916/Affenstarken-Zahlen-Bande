package entities;

public class Monkey {

    public int location;
    public String color;
    public String path;

    public Monkey(String color, String path){
        this.location = 0;
        this.color = color;
        this.path = "img/monkey_"+ color +".png";
    }

    public void move(int location){
        this.location = location;
    }
}
