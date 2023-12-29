package managers;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

import org.w3c.dom.Text;

import entities.*;
public class PlayStateController {

    public static Texture cordMap = new Texture("img/cordMap.png");
    public static Texture card = new Texture("img/card.png");
    public static Texture avatar = new Texture("img/P2_avatar.png");

    public static Texture special = new Texture("img/special_1.png");

    public static Texture leaf = new Texture("img/leaf_top_right_yellow.png");

    public static void update(){

    }

    public static void draw(){
        Game.batch.draw(cordMap,Cords.cordMap_x,Cords.cordMap_y);
        Game.batch.draw(card,Cords.top_card_4_x,Cords.top_card_4_y);
        Game.batch.draw(avatar, Cords.top_avatar_x, Cords.top_avatar_y);
        Game.batch.draw(special, Cords.special_4_x, Cords.special_4_y);
        Game.batch.draw(leaf,0,0);
    }

    public static void dispose(){

        cordMap.dispose();
    }
}
