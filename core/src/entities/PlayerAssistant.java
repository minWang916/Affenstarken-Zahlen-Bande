package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.Game;
import managers.PlayStateController;

public class PlayerAssistant {
    private static BitmapFont font;
    public PlayerAssistant(){
        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
                Gdx.files.internal("font/VCR_OSD_MONO_1.001.ttf")
        );

        FreeTypeFontGenerator.FreeTypeFontParameter param_titleFont = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param_titleFont.size = 17;
        font = gen.generateFont(param_titleFont);
        font.setColor(Color.BLACK);
    }

    public static void draw(){
        String title = "Phase " + Cords.phases[PlayStateController.phase];
        font.draw(Game.batch,title,(Game.WIDTH - 150),(Game.HEIGHT - 30));
        String weightMessage = "Weight: " + Math.ceil(PlayStateController.currentWeight) + "/" + Math.ceil(PlayStateController.maxWeight);
        font.draw(Game.batch, weightMessage, 20, (Game.HEIGHT-30));
    }
}
