package entities;

public class Player {

    private String name;

    private String state = "";

    private boolean playing = false;

    public Player (String name) {
        this.name = name;
        System.out.println("Player created with the name " + this.name);
    }

    public void init(){

    }

    public void update(){

    }

    public void draw(){

    }

    public void startTurn(){
        System.out.println("This is my turn and I am " + name);
        playing = true;
    }

    public void endTurn(){
        System.out.println("I am ending my turn and I am " + name);
        playing = false;
    }
}
