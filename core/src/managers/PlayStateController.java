package managers;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

import org.w3c.dom.Text;

import entities.*;
public class PlayStateController {

    public static Texture cordMap = new Texture("img/cordMap.png");
    public static Texture card = new Texture("img/card.png");
    public static Texture avatar = new Texture("img/P2_avatar.png");

    public static Texture special = new Texture("img/1.png");

    public static void draw(){
        Game.batch.draw(cordMap,Cords.cordMap_x,Cords.cordMap_y);
        Game.batch.draw(card,Cords.top_card_4_x,Cords.top_card_4_y);
        Game.batch.draw(avatar, Cords.top_avatar_x, Cords.top_avatar_y);
        //Game.batch.draw(special,);
    }

    public static void dispose(){
        cordMap.dispose();
    }
}
