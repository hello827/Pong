package Scene;

import com.RivelWorks.Core;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rivelbop.rivelworks.RivelWorks;
import com.rivelbop.rivelworks.ui.Font;
import com.rivelbop.rivelworks.util.Utils;

public class MainMenu implements Screen {

    private SpriteBatch batch;
    private Font font;

    @Override
    public void show() {
        batch = new SpriteBatch();
        Font.FontBuilder builder = new Font.FontBuilder();
        font = builder.
            setFont(Gdx.files.internal("pixel.ttf")).
            setSize(50).
            build();
        builder.dispose();
    }

    @Override
    public void render(float delta) {
        Utils.clearScreen2D();

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            ((Pong) Gdx.app.getApplicationListener()).setScreen(new SelectionMenu());
        }

        batch.begin();
        font.drawCenter(batch, "Press Space To Play", Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
