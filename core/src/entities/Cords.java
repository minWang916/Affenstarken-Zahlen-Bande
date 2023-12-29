package entities;

public class Cords {
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
    public static final float right_card_4_y = 863;

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

    public static final float elephant_1_x = 24;
    public static final float elephant_1_y = 29;

    public static final float elephant_2_x = 113;
    public static final float elephant_2_y = 29;



    //------------------------------------------------------Elephant---------------------------------------------------


    //----------------------------------------------Confirm & Cancel buttons-------------------------------------------



    //----------------------------------------------Confirm & Cancel buttons-------------------------------------------



}
