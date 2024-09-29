package Scene;

import com.RivelWorks.AiCore;
import com.RivelWorks.Core;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rivelbop.rivelworks.ui.Font;
import com.rivelbop.rivelworks.util.Utils;

public class SelectionMenu implements Screen {

    private SpriteBatch batch;
    private Font font;

    @Override
    public void show() {
        batch = new SpriteBatch();
        Font.FontBuilder builder = new Font.FontBuilder();
        font = builder.
            setFont(Gdx.files.internal("pixel.ttf")).
            setSize(40).
            setColor(Color.YELLOW).
            build();
        builder.dispose();
    }

    @Override
    public void render(float delta) {
        Utils.clearScreen2D();

        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            ((Pong) Gdx.app.getApplicationListener()).setScreen(new Core());
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            ((Pong) Gdx.app.getApplicationListener()).setScreen(new AiCore());
        }
        batch.begin();
        font.drawCenter(batch, "1. Player Versus Player", Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f + 75f);
        font.drawCenter(batch, "2. Player Versus AI", Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f - 75f);
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
