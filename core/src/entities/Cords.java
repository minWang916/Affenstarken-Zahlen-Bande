package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Cords {
    //-----------------------------------------------Leaves------------------------------------------------------------
    public static Texture bottom_left_green = new Texture("img/leaves/leaf_bottom_left_green.png");
    public static Texture bottom_left_yellow = new Texture("img/leaves/leaf_bottom_left_yellow.png");
    public static Texture bottom_left_red = new Texture("img/leaves/leaf_bottom_left_red.png");
    public static Texture bottom_right_green = new Texture("img/leaves/leaf_bottom_right_green.png");
    public static Texture bottom_right_yellow = new Texture("img/leaves/leaf_bottom_right_yellow.png");
    public static Texture bottom_right_red = new Texture("img/leaves/leaf_bottom_right_red.png");
    public static Texture top_right_green = new Texture("img/leaves/leaf_top_right_green.png");
    public static Texture top_right_yellow = new Texture("img/leaves/leaf_top_right_yellow.png");
    public static Texture top_right_red = new Texture("img/leaves/leaf_top_right_red.png");
    public static Texture top_left_green = new Texture("img/leaves/leaf_top_left_green.png");
    public static Texture top_left_yellow = new Texture("img/leaves/leaf_top_left_yellow.png");
    public static Texture top_left_red = new Texture("img/leaves/leaf_top_left_red.png");
    public static Texture[] leaf_top_right = new Texture[]{top_right_green, top_right_yellow, top_right_red};
    public static Texture[] leaf_bottom_right = new Texture[]{bottom_right_green, bottom_right_yellow, bottom_right_red};
    public static Texture[] leaf_bottom_left = new Texture[]{bottom_left_green, bottom_left_yellow, bottom_left_red};
    public static Texture[] leaf_top_left = new Texture[]{top_left_green, top_left_yellow, top_left_red};
    public static Texture[][][] leaf_asset = new Texture[][][] { {leaf_bottom_left, leaf_bottom_right}, {leaf_top_left, leaf_top_right} };
    //-----------------------------------------------Leaves------------------------------------------------------------

    //-----------------------------------------------Board Coordinates-------------------------------------------------
    public static final float cordMap_x = 0;
    public static final float cordMap_y = 0;

    public static float[][] cord = {
            {470,372},
            {515,420},
            {519,330},
            {430,330},
            {430,420},
            {536,475},
            {580,420},
            {575,310},
            {535,263},
            {411,263},
            {370,310},
            {370,420},
            {421,480},
            {560,530},
            {635,450},
            {635,295},
            {555,205},
            {383,205},
            {305,295},
            {309,465},
            {398,540}
    };
    //-----------------------------------------------Board Coordinates-------------------------------------------------

    //------------------------------------------------------Bottom-----------------------------------------------------
    public static final float bottom_avatar_x = 255;
    public static final float bottom_avatar_y = 48;
    public static final float bottom_card_1_x = 360;
    public static final float bottom_card_1_y = 37;
    public static final float bottom_card_2_x = 464;
    public static final float bottom_card_2_y = 37;
    public static final float bottom_card_3_x = 570;
    public static final float bottom_card_3_y = 37;
    public static final float bottom_card_4_x = 672;
    public static final float bottom_card_4_y = 37;

    public static float[][] bottom_player = {
            {bottom_avatar_x, bottom_avatar_y},
            {bottom_card_1_x, bottom_card_1_y},
            {bottom_card_2_x, bottom_card_2_y},
            {bottom_card_3_x, bottom_card_3_y},
            {bottom_card_4_x, bottom_card_4_y}
    };

    //------------------------------------------------------Bottom-----------------------------------------------------

    //--------------------------------------------------------Top------------------------------------------------------

    public static final float top_avatar_x = 255;
    public static final float top_avatar_y = 675;
    public static final float top_card_1_x = 360;
    public static final float top_card_1_y = 666;
    public static final float top_card_2_x = 464;
    public static final float top_card_2_y = 666;
    public static final float top_card_3_x = 570;
    public static final float top_card_3_y = 666;
    public static final float top_card_4_x = 672;
    public static final float top_card_4_y = 666;

    public static float[][] top_player = {
            {top_avatar_x, top_avatar_y},
            {top_card_1_x, top_card_1_y},
            {top_card_2_x, top_card_2_y},
            {top_card_3_x, top_card_3_y},
            {top_card_4_x, top_card_4_y}
    };

    //--------------------------------------------------------Top------------------------------------------------------


    //--------------------------------------------------------Left-----------------------------------------------------

    public static final float left_avatar_x = 59;
    public static final float left_avatar_y = 605;
    public static final float left_card_1_x = 35;
    public static final float left_card_1_y = 517;
    public static final float left_card_2_x = 35;
    public static final float left_card_2_y = 413;
    public static final float left_card_3_x = 35;
    public static final float left_card_3_y = 314;
    public static final float left_card_4_x = 35;
    public static final float left_card_4_y = 214;

    public static float[][] left_player = {
            {left_avatar_x, left_avatar_y},
            {left_card_1_x, left_card_1_y},
            {left_card_2_x, left_card_2_y},
            {left_card_3_x, left_card_3_y},
            {left_card_4_x, left_card_4_y}
    };

    //--------------------------------------------------------Left-----------------------------------------------------


    //-------------------------------------------------------Right-----------------------------------------------------

    public static final float right_avatar_x = 884;
    public static final float right_avatar_y = 605;
    public static final float right_card_1_x = 863;
    public static final float right_card_1_y = 517;
    public static final float right_card_2_x = 863;
    public static final float right_card_2_y = 413;
    public static final float right_card_3_x = 863;
    public static final float right_card_3_y = 314;
    public static final float right_card_4_x = 863;
    public static final float right_card_4_y = 214;

    public static float[][] right_player = {
            {right_avatar_x, right_avatar_y},
            {right_card_1_x, right_card_1_y},
            {right_card_2_x, right_card_2_y},
            {right_card_3_x, right_card_3_y},
            {right_card_4_x, right_card_4_y}
    };

    //-------------------------------------------------------Right-----------------------------------------------------

    //-------------------------------------------------------All cards-------------------------------------------------

    public static float[][][] all_player_cord = {
            top_player,
            right_player,
            bottom_player,
            left_player
    };

    //-------------------------------------------------------All cards-------------------------------------------------

    //-------------------------------------------------------Card asset------------------------------------------------

    public static Texture card_asset_green = new Texture("img/card_asset/green_card.png");
    public static Texture card_asset_blue = new Texture("img/card_asset/blue_card.png");
    public static Texture card_asset_orange = new Texture("img/card_asset/orange_card.png");
    public static Texture card_asset_pink = new Texture("img/card_asset/pink_card.png");
    public static Texture card_asset_transparent = new Texture("img/card_asset/transparent_card.png");
    public static Texture[] card_asset_color = new Texture[]{card_asset_orange,
            card_asset_green, card_asset_blue, card_asset_pink, card_asset_transparent};
    public static String[] colors = {"orange", "green", "blue", "pink"};

    public static Texture card_asset_5 = new Texture("img/card_asset/5_card.png");
    public static Texture card_asset_6 = new Texture("img/card_asset/6_card.png");
    public static Texture card_asset_7 = new Texture("img/card_asset/7_card.png");
    public static Texture card_asset_8 = new Texture("img/card_asset/8_card.png");
    public static Texture card_asset_9 = new Texture("img/card_asset/9_card.png");
    public static Texture card_asset_10 = new Texture("img/card_asset/10_card.png");
    public static Texture card_asset_11 = new Texture("img/card_asset/11_card.png");
    public static Texture card_asset_12 = new Texture("img/card_asset/12_card.png");
    public static Texture card_asset_13 = new Texture("img/card_asset/13_card.png");
    public static Texture card_asset_14 = new Texture("img/card_asset/14_card.png");
    public static Texture card_asset_15 = new Texture("img/card_asset/15_card.png");
    public static Texture[] card_asset_number = new Texture[]{card_asset_5, card_asset_6, card_asset_7,
            card_asset_8, card_asset_9, card_asset_10, card_asset_11, card_asset_12, card_asset_13,
            card_asset_14, card_asset_15};

    //-------------------------------------------------------Card asset------------------------------------------------

    //------------------------------------------------------Special----------------------------------------------------
    public static final float special_1_x = 193;
    public static final float special_1_y = 514;
    public static final float special_2_x = 193;
    public static final float special_2_y = 353;

    public static final float special_3_x = 193;
    public static final float special_3_y = 195;

    public static final float special_4_x = 725;
    public static final float special_4_y = 514;

    public static final float special_5_x = 725;
    public static final float special_5_y = 353;

    public static final float special_6_x = 725;
    public static final float special_6_y = 195;

    public static float[][] special = {
            {special_1_x, special_1_y},
            {special_2_x, special_2_y},
            {special_3_x, special_3_y},
            {special_4_x, special_4_y},
            {special_5_x, special_5_y},
            {special_6_x, special_6_y}
    };

    //------------------------------------------------------Special----------------------------------------------------


    //------------------------------------------------------Elephant---------------------------------------------------

    public static final float elephant_1_x = 40;
    public static final float elephant_1_y = 10;

    public static final float elephant_2_x = 40;
    public static final float elephant_2_y = 85;

    //------------------------------------------------------Elephant---------------------------------------------------

    //------------------------------------------------------  Weight ---------------------------------------------------

    public static double[] xWeightSign = {0, 1, 1, -1, -1, 1,1,1,1,-1,-1,-1,-1,-1,1,1,1,1,-1,-1,-1,-1};
    public static double[] yWeightSign = {0,1,-1,-1,1,1,1,-1,-1,-1,-1,1,1,1,1,-1,-1,-1,-1,1,1};

    //------------------------------------------------------  Weight ---------------------------------------------------


    //----------------------------------------------Confirm & Cancel buttons-------------------------------------------

    public static Sound btnSound = Gdx.audio.newSound(Gdx.files.internal("sound/se/confirm.mp3"));
    public static Sound selectSound = Gdx.audio.newSound(Gdx.files.internal("sound/se/select.mp3"));
    public static Sound unselectSound = Gdx.audio.newSound(Gdx.files.internal("sound/se/deselect.mp3"));

    //----------------------------------------------Confirm & Cancel buttons-------------------------------------------

    //----------------------------------------------Phase--------------------------------------------------------------
    public static String[] phases = {"Special", "Monkey", "Elephant"};
    //----------------------------------------------Phase--------------------------------------------------------------

}
