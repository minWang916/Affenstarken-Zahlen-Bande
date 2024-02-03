package gamestates;

import org.w3c.dom.Text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.Game;

import managers.GameStateManager;

public class GuideState extends GameState{

    boolean isPlayed = false;
    Sound[] sub;
    public Texture[] pics;
    public int count = 0;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private TmxMapLoader mapLoader;
    public Texture chibi;

    public Texture board;
    public Texture btnBack;
    public Texture btnNext;

    public static float pic_x;
    public Texture yasuo;
    public static float pic_y;
    public Texture wood;
    public BitmapFont font;
    public BitmapFont name;
    public GlyphLayout layout = new GlyphLayout();

    String[] line = {
            "Welcome to Affenstarke Zahlenbande. My name is \nCaitlynn and I will guide how to play our game.",
            "Here is what the game board looks like. Now, lets \nbegin.",
            "On the four sides of the map are the player areas \nwith their own monkey cards. In the middle is the \ntree map with the monkeys and elephant at \nlocation 0.",
            "Next are the 6 special cards around the map and \nthe 2 elephant cards at the bottom left corner.",
            "On the top screen left, there is the weight status \nwhich tells the current heaviest weight and on the \nright is the setting icon for you to access \nthe settings.",
            "The green player name means special phase and you \ncan use the special cards. The special phase can \nbe skipped.",
            "The player skips his turn to the next player, who \nskips the special phase and move to monkey phase, \nwhere the player name is yellow and can use monkey \ncards to move monkeys.",
            "The player chooses to minus 13 green with 6 green. \nAs a result, the green monkey moves to location 13.",
            "The player then moves to elephant phase, which has \nthe player name color orange. The elephant phase \nis the last phase of a player turn and can also \nbe skipped.",
            "The player chooses the elephant card number 2 and \nclicks confirm.",
            "The elephant moves to location 2 and the elephant \ncard number 2 is swapped to number 4. This ends \nthe current player's turn and move on to the next \nplayer, who starts with special phase.",
            "This is how the game looks after several turns.",
            "Be careful, the leaf will turn red if it is too \nheavy and you might lose. You can check the weight \nat the top left corner. Green leaf is normal, \nyellow leaf is medium and red leaf is danger.",
            "That's it for me. Click the next button one more \ntime to play. I hope you'll have a good time \nenjoying our game.",
    };

    String nameText = "Sheriff Caitlynn";
    public GuideState (GameStateManager gsm){
        super(gsm);
        init();
    }
    @Override
    public void init() {

        sub = new Sound[]{
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/0.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/1.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/2.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/3.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/4.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/5.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/6.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/7.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/8.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/9.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/10.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/11.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/12.mp3")),
                Gdx.audio.newSound(Gdx.files.internal("sound/voice/13.mp3"))
        };

        pics = new Texture[]{
            new Texture("guides/slides/0.png"),
            new Texture("guides/slides/1.png"),
            new Texture("guides/slides/2.png"),
            new Texture("guides/slides/3.png"),
            new Texture("guides/slides/4.png"),
            new Texture("guides/slides/5.png"),
            new Texture("guides/slides/6.png"),
            new Texture("guides/slides/7.png"),
            new Texture("guides/slides/8.png"),
            new Texture("guides/slides/9.png"),
            new Texture("guides/slides/10.png"),
            new Texture("guides/slides/11.png"),
            new Texture("guides/slides/12.png"),
            new Texture("guides/slides/13.png")
        };

        font = new BitmapFont();
        name = new BitmapFont();
        FreeTypeFontGenerator generator1 = new FreeTypeFontGenerator(
                Gdx.files.internal("font/VCR_OSD_MONO_1.001.ttf")
        );

        FreeTypeFontGenerator generator2 = new FreeTypeFontGenerator(
                Gdx.files.internal("font/VCR_OSD_MONO_1.001.ttf")
        );

        FreeTypeFontGenerator.FreeTypeFontParameter param_notiFont = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param_notiFont.size = 25;
        param_notiFont.borderWidth = 1;
        param_notiFont.borderColor = Color.BLACK;

        FreeTypeFontGenerator.FreeTypeFontParameter param_nameFont = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param_nameFont.size = 25;
        param_nameFont.borderWidth = 1;
        param_nameFont.borderColor = Color.BLACK;

        name = generator2.generateFont(param_nameFont);
        name.setColor(Color.WHITE);

        font = generator1.generateFont(param_notiFont);
        font.setColor(Color.BROWN);

        chibi = new Texture("guides/chibi.png");
        wood = new Texture("guides/woodenBoard.png");
        count = 0;

        btnNext = new Texture("guides/btnNext.png");
        yasuo = new Texture("guides/yasuo.png");

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("guides/guide.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        Game.cam.position.set(Game.gamePort.getWorldWidth()/2, Game.gamePort.getWorldHeight()/2,0);

        board = new Texture("guides/real.png");

    }

    @Override
    public void update(float var1) {
        Game.cam.update();
        renderer.setView(Game.cam);
    }

    @Override
    public void draw() {


        Game.batch.begin();
        renderer.render();

        //Game.batch.draw(bg,-Game.WIDTH/2,-Game.HEIGHT/2);
        //Game.batch.draw(board, 80 - -Game.WIDTH/2, 100 -Game.HEIGHT/2);

        Game.batch.draw(board, 30, 40);



        Game.batch.draw(chibi,750,150);
        Game.batch.draw(wood,200,250);


        if(isPlayed == false){
            sub[count].play();
            isPlayed = true;
        }

        layout.setText(font, line[count]);
        font.draw(Game.batch, line[count], 60,160);
        layout.setText(font, nameText);
        name.draw(Game.batch, nameText, 150,210);


        Game.batch.draw(pics[count],250,300);

        Game.batch.draw(btnNext,880,100);
        handleInput();
        Game.batch.end();
    }

    @Override
    public void handleInput() {
        float X = Gdx.input.getX();
        float Y = Gdx.graphics.getHeight() - Gdx.input.getY();

        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){

            if(880 < X && X < 850 + 100 && 100 < Y && Y < 100 + 38){
                count = count + 1;
                isPlayed = false;
                if(count == 14){
                    gsm.setState(gsm.PLAY);
                }
            }
        }
    }

    @Override
    public void dispose() {
        yasuo.dispose();

        btnNext.dispose();
        chibi.dispose();
        for(int i = 0; i < count;i++){
            pics[i].dispose();
            sub[i].dispose();
        }
        font.dispose();
        name.dispose();
    }
}
