package gamestates;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.Game;
import managers.GameStateManager;

public class MenuState extends GameState{


    private SpriteBatch sb;
    private BitmapFont titleFont;
    private BitmapFont Font;

    private Stage stage;

    GlyphLayout layout;

    private Skin skin;

    private final String title = "Affenstarke Zahlen-Bande";

    private int currentItem;
    private String[] menuItems;
    public MenuState (GameStateManager gsm){
        super(gsm);
        init();
    }

    public void init(){

        sb = new SpriteBatch();
        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
                Gdx.files.internal("font/VCR_OSD_MONO_1.001.ttf")
        );

        FreeTypeFontGenerator.FreeTypeFontParameter param_titleFont = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param_titleFont.size = 56;
        titleFont = gen.generateFont(param_titleFont);
        titleFont.setColor(Color.WHITE);
        layout = new GlyphLayout(titleFont,title);


        FreeTypeFontGenerator.FreeTypeFontParameter param_font = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param_font.size = 20;
        Font = gen.generateFont(param_font);

        menuItems = new String[]{
                "Play",
                "Highscores", "Quit"
        };

        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        skin = new Skin();

    };
    public void update(float var1){

        System.out.println("MENU STATE UPDATING");

        handleInput();



    }

    public void draw(){
        System.out.println("MENU STATE DRAWING");
        sb.setProjectionMatrix(Game.cam.combined);

        sb.begin();

        float width = layout.width;
        float height = layout.height;
        titleFont.draw(sb,title,(Game.WIDTH - width)/2,(Game.HEIGHT - height*2));

        if(stage != null){
            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();
        }

        sb.end();
    }

    public void handleInput(){

        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){

            gsm.setState(gsm.PLAY);

        }

    }

    public void dispose(){
        stage.dispose();
        sb.dispose();
        Font.dispose();
        titleFont.dispose();
    }
}
