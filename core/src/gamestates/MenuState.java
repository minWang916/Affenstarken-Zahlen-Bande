package gamestates;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.Game;
import managers.GameStateManager;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MenuState extends GameState{



    private BitmapFont titleFont;
    private BitmapFont font;

    private Stage stage;

    private TextureAtlas buttonAtlas;
    GlyphLayout layout;

    private Skin skinButton;
    private TextButton.TextButtonStyle textButtonStyle;
    private TextButton startButton, helpButton, quitButton;

    private final String title = "Affenstarke Zahlen-Bande";

    private TextField[] nameFields;
    private Window namesWindow;

    private ImageButton updateButton,cancelButton;

    private String textsInput;
    private int currentItem;
    private String[] menuItems;
    public MenuState (GameStateManager gsm){
        super(gsm);
        init();
    }


    public void init(){

        float buttonHeight = 100;
        float buttonWidth = 200;

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
        Gdx.input.setInputProcessor(stage);

        skinButton = new Skin(Gdx.files.internal("glassy_ui/glassy-ui.json"));
        buttonAtlas = new TextureAtlas("glassy_ui/glassy-ui.atlas");
        skinButton.addRegions(buttonAtlas);



        textButtonStyle = new TextButton.TextButtonStyle();
//        textButtonStyle.up = skinButton.getDrawable("up-button");
//        textButtonStyle.over = skinButton.getDrawable("buttons/buttonpressed.png");
//        textButtonStyle.down = skinButton.getDrawable("buttons/buttonpressed.png");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = font;


        startButton=new TextButton("Start",textButtonStyle);
        startButton.setText("Start");
        startButton.setHeight(buttonHeight);
        startButton.setWidth(buttonWidth);
        startButton.setPosition(400,500);
        
        //button


        helpButton = new TextButton("Help",textButtonStyle);
        helpButton.setHeight(buttonHeight);
        helpButton.setWidth(buttonWidth);
        helpButton.setPosition(400,400);

        quitButton = new TextButton("Quit",textButtonStyle);
        quitButton.setHeight(buttonHeight);
        quitButton.setWidth(buttonWidth);
        quitButton.setPosition(400,300);

        namesWindow = new Window("Input your name",skinButton);
        Drawable confirmImg = new TextureRegionDrawable(new TextureRegion(new Texture("img/button_confirm.png")));
        Drawable closeImg = new TextureRegionDrawable(new TextureRegion(new Texture("img/button_cancle.png")));
        updateButton = new ImageButton(confirmImg);
        cancelButton = new ImageButton(closeImg);


        nameFields = new TextField[4];
        VerticalGroup vg = new VerticalGroup();
        HorizontalGroup hg = new HorizontalGroup();
        for (int i=0;i<nameFields.length;i++){
            nameFields[i]= new TextField("name",skinButton);

            vg.addActor(nameFields[i]);
            vg.space(10);
//            namesWindow.add(nameFields[i]).pad(10).fillY().align(Align.top);
        }
        hg.addActor(cancelButton);
        hg.addActor(updateButton);
        hg.space(10);
        vg.addActor(hg);
        namesWindow.add(vg);
//

        namesWindow.setResizable(true);

        namesWindow.setBounds(200,300,300,350);
        namesWindow.align(Align.top);
        namesWindow.center();


        stage.addActor(startButton);
        stage.addActor(helpButton);
        stage.addActor(quitButton);

//        stage.addActor(nameFields[1]);
        stage.addActor(namesWindow);
        namesWindow.setVisible(false);


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

        if(startButton.isPressed()){

            gsm.setState(gsm.PLAY);

        }
        if(helpButton.isPressed()){
            namesWindow.setVisible(true);
            nameFields[1].setDisabled(false);



        }
        if(quitButton.isPressed()){

            System.out.println("Quit pressed");

        }
        if (updateButton.isPressed()){
            namesWindow.setVisible(false);
            textsInput=nameFields[1].getText();
            nameFields[1].setDisabled(true);

        }

    }

    public void dispose(){
        stage.dispose();
        font.dispose();
        titleFont.dispose();
    }
}
