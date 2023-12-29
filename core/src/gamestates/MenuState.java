package gamestates;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.Game;
import managers.GameStateManager;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import org.w3c.dom.Text;

public class MenuState extends GameState{



    private BitmapFont titleFont;
    private BitmapFont font;

    private Stage stage;

    private TextureAtlas buttonAtlas;
    GlyphLayout layout;

    private Skin skinButton;
    private TextButton.TextButtonStyle textButtonStyle;
    private TextButton button;

    private final String title = "Affenstarke Zahlen-Bande";

    private int currentItem;
    private String[] menuItems;
    public MenuState (GameStateManager gsm){
        super(gsm);
        init();
    }

    public void init(){


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
        font = gen.generateFont(param_font);

        menuItems = new String[]{
                "Play",
                "Highscores", "Quit"
        };

        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        skinButton = new Skin(Gdx.files.internal("glassy_ui/glassy-ui.json"));
        buttonAtlas = new TextureAtlas("glassy_ui/glassy-ui.atlas");
        skinButton.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;




        button=new TextButton("Finish",textButtonStyle);
        button.setText("Start");
        button.setHeight(230);
        button.setWidth(500);
        button.setPosition(50,50);
        stage.addActor(button);

    };
    public void update(float var1){

        //System.out.println("MENU STATE UPDATING");

        handleInput();



    }

    public void draw(){
        //System.out.println("MENU STATE DRAWING");
        Game.batch.setProjectionMatrix(Game.cam.combined);

        Game.batch.begin();

        float width = layout.width;
        float height = layout.height;
        titleFont.draw(Game.batch,title,(Game.WIDTH - width)/2,(Game.HEIGHT - height*2));

        if(stage != null){
            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();
        }

        Game.batch.end();
    }

    public void handleInput(){

        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){

            gsm.setState(gsm.PLAY);

        }

    }

    public void dispose(){
        stage.dispose();
        font.dispose();
        titleFont.dispose();
    }
}
