package Scene;

import com.RivelWorks.Core;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pong extends Game {

    public SpriteBatch batch;
    public BitmapFont font;


    @Override
    public void create() {
        this.setScreen(new MainMenu());
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
