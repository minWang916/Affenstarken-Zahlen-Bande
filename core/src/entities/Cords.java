package entities;

public class Cords {
    //-----------------------------------------------Board Coordinates-------------------------------------------------
    public static final float cordMap_x = 0;
    public static final float cordMap_y = 0;
    //-----------------------------------------------Board Coordinates-------------------------------------------------

    //------------------------------------------------------Bottom-----------------------------------------------------
    public static final float bottom_avatar_x = 255;
    public static final float bottom_avatar_y = 43;
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
    public static final float top_avatar_y = 705;
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

    public static float all_player_cord[][][] = {
            top_player,
            right_player,
            bottom_player,
            left_player
    };

    //-------------------------------------------------------All cards-------------------------------------------------

    //------------------------------------------------------Special----------------------------------------------------

    //------------------------------------------------------Special----------------------------------------------------


    //------------------------------------------------------Elephant---------------------------------------------------

    public  static float elephent_cord[][] ={
            {24, 29},
            {113, 29}
    };

    //------------------------------------------------------Elephant---------------------------------------------------


    //----------------------------------------------Confirm & Cancel buttons-------------------------------------------

    //----------------------------------------------Confirm & Cancel buttons-------------------------------------------


    //--------------------------------------------------------Leaves---------------------------------------------------

    //--------------------------------------------------------Leaves---------------------------------------------------
}
